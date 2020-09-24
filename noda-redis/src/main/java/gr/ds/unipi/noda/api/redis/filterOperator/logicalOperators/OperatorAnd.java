package gr.ds.unipi.noda.api.redis.filterOperator.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators.*;

import java.util.*;

final class OperatorAnd extends LogicalOperator {

    private OperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);

        FilterOperator[] fops = new FilterOperator[filterOperators.length+2];
        fops[0] = filterOperator1;
        fops[1] = filterOperator2;

        if(filterOperators.length != 0){
            int i = 2;
            while(i< fops.length){
                fops[i] = filterOperators[i-2];
                i++;
            }
        }

        Map<String, Map.Entry<ComparisonOperator[], List<ComparisonOperator>>> hashMap = new HashMap<>();

        List<FilterOperator> fopsList = new ArrayList<>(Arrays.asList(fops));

        fopsList.forEach(filterOperator -> {

            if((filterOperator instanceof OperatorGreaterThan) || (filterOperator instanceof OperatorGreaterThanEqual)
                    || (filterOperator instanceof OperatorLessThan) || (filterOperator instanceof OperatorLessThanEqual)){

                if(hashMap.containsKey(((ComparisonOperator) filterOperator).getFieldName())){

                    Map.Entry<ComparisonOperator[],List<ComparisonOperator>> entry = hashMap.get(((ComparisonOperator) filterOperator).getFieldName());

                    List<ComparisonOperator> entryList = entry.getValue();

                    ComparisonOperator[] comparisonOperator = entry.getKey();

                    if((filterOperator instanceof OperatorGreaterThan) || (filterOperator instanceof OperatorGreaterThanEqual)){
                        if(comparisonOperator[0] == null){
                            comparisonOperator[0] = (ComparisonOperator) filterOperator;
                        }
                        else{
                            if((Double.compare(new Double(String.valueOf(comparisonOperator[0].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperator).getFieldValue())))==-1)){
                                comparisonOperator[0] = (ComparisonOperator) filterOperator;
                            }
                            else if((Double.compare(new Double(String.valueOf(comparisonOperator[0].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperator).getFieldValue())))==0)){
                                if(comparisonOperator[0].getClass() != filterOperator.getClass()){
                                    if(comparisonOperator[0].getClass() == OperatorGreaterThanEqual.class){
                                        comparisonOperator[0] = (ComparisonOperator) filterOperator;
                                    }
                                }
                            }
                        }
                    }else{
                        if(comparisonOperator[1] == null){
                            comparisonOperator[1] = (ComparisonOperator) filterOperator;
                        }
                        else{
                            if((Double.compare(new Double(String.valueOf(comparisonOperator[1].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperator).getFieldValue())))==1)){
                                comparisonOperator[1] = (ComparisonOperator) filterOperator;
                            }
                            else if((Double.compare(new Double(String.valueOf(comparisonOperator[1].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperator).getFieldValue())))==0)){
                                if(comparisonOperator[1].getClass() != filterOperator.getClass()){
                                    if(comparisonOperator[1].getClass() == OperatorLessThanEqual.class){
                                        comparisonOperator[1] = (ComparisonOperator) filterOperator;
                                    }
                                }
                            }
                        }
                    }
                    entryList.add((ComparisonOperator) filterOperator);
                }else{
                    ComparisonOperator[] comparisonOperators = new ComparisonOperator[2];
                    if((filterOperator instanceof OperatorGreaterThan) || (filterOperator instanceof OperatorGreaterThanEqual)){
                        comparisonOperators[0] = (ComparisonOperator) filterOperator;
                    }else{
                        comparisonOperators[1] = (ComparisonOperator) filterOperator;
                    }
                    List<ComparisonOperator> records = new ArrayList<>();
                    records.add((ComparisonOperator) filterOperator);
                    Map.Entry entr = new AbstractMap.SimpleEntry<>(comparisonOperators, records);
                    hashMap.put(((ComparisonOperator) filterOperator).getFieldName(), entr);
                }


            }
            else{
                return;
            }
        });

        hashMap.forEach((i,v)->{
            if(v.getValue().size()>1){

                FilterOperator filt;

                if(v.getKey()[0] == null){
                    filt = v.getKey()[1];
                }
                else if(v.getKey()[1] == null){
                    filt = v.getKey()[0];
                }
                else if(Double.compare(new Double(String.valueOf(v.getKey()[0].getFieldValue())),new Double(String.valueOf(v.getKey()[1].getFieldValue()))) == -1){
                    filt = Range.newRange(v.getKey()[0], v.getKey()[1]);
                }
                else{
                    return;
                }

                List<ComparisonOperator> l =  v.getValue();
                int indexOfReplacing = fopsList.indexOf(l.get(0));
                fopsList.set(indexOfReplacing, filt);
                for (int y = 1; y < l.size(); y++) {
                    fopsList.remove(l.get(y));
                }
            }
        });

        setFilterOperatorChildren(fopsList.toArray(new FilterOperator[fopsList.size()]));

    }

    public static OperatorAnd newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

}
