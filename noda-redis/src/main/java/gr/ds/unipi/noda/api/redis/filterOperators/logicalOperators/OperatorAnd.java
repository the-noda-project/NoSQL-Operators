package gr.ds.unipi.noda.api.redis.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.redis.filterOperators.comparisonOperators.*;

final class OperatorAnd extends LogicalOperator {

    private OperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(-1, OperatorGreaterThanEqual.class, OperatorLessThanEqual.class, filterOperator1, filterOperator2, filterOperators);
//
//        FilterOperator[] fops = new FilterOperator[filterOperators.length+2];
//        fops[0] = filterOperator1;
//        fops[1] = filterOperator2;
//
//        if(filterOperators.length != 0){
//            int i = 2;
//            while(i< fops.length){
//                fops[i] = filterOperators[i-2];
//                i++;
//            }
//        }
//
//        Map<String, Map.Entry<ComparisonOperator[], List<ComparisonOperator>>> hashMap = new HashMap<>();
//
//        List<FilterOperator> fopsList = new ArrayList<>(Arrays.asList(fops));
//
//        fopsList.forEach(filterOperators -> {
//
//            if((filterOperators instanceof OperatorGreaterThan) || (filterOperators instanceof OperatorGreaterThanEqual)
//                    || (filterOperators instanceof OperatorLessThan) || (filterOperators instanceof OperatorLessThanEqual)){
//
//                if(hashMap.containsKey(((ComparisonOperator) filterOperators).getFieldName())){
//
//                    Map.Entry<ComparisonOperator[],List<ComparisonOperator>> entry = hashMap.get(((ComparisonOperator) filterOperators).getFieldName());
//
//                    List<ComparisonOperator> entryList = entry.getValue();
//
//                    ComparisonOperator[] comparisonOperator = entry.getKey();
//
//                    if((filterOperators instanceof OperatorGreaterThan) || (filterOperators instanceof OperatorGreaterThanEqual)){
//                        if(comparisonOperator[0] == null){
//                            comparisonOperator[0] = (ComparisonOperator) filterOperators;
//                        }
//                        else{
//                            if((Double.compare(new Double(String.valueOf(comparisonOperator[0].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperators).getFieldValue())))==-1)){
//                                comparisonOperator[0] = (ComparisonOperator) filterOperators;
//                            }
//                            else if((Double.compare(new Double(String.valueOf(comparisonOperator[0].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperators).getFieldValue())))==0)){
//                                if(comparisonOperator[0].getClass() != filterOperators.getClass()){
//                                    if(comparisonOperator[0].getClass() == OperatorGreaterThanEqual.class){
//                                        comparisonOperator[0] = (ComparisonOperator) filterOperators;
//                                    }
//                                }
//                            }
//                        }
//                    }else{
//                        if(comparisonOperator[1] == null){
//                            comparisonOperator[1] = (ComparisonOperator) filterOperators;
//                        }
//                        else{
//                            if((Double.compare(new Double(String.valueOf(comparisonOperator[1].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperators).getFieldValue())))==1)){
//                                comparisonOperator[1] = (ComparisonOperator) filterOperators;
//                            }
//                            else if((Double.compare(new Double(String.valueOf(comparisonOperator[1].getFieldValue())), new Double(String.valueOf(((ComparisonOperator) filterOperators).getFieldValue())))==0)){
//                                if(comparisonOperator[1].getClass() != filterOperators.getClass()){
//                                    if(comparisonOperator[1].getClass() == OperatorLessThanEqual.class){
//                                        comparisonOperator[1] = (ComparisonOperator) filterOperators;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    entryList.add((ComparisonOperator) filterOperators);
//                }else{
//                    ComparisonOperator[] comparisonOperators = new ComparisonOperator[2];
//                    if((filterOperators instanceof OperatorGreaterThan) || (filterOperators instanceof OperatorGreaterThanEqual)){
//                        comparisonOperators[0] = (ComparisonOperator) filterOperators;
//                    }else{
//                        comparisonOperators[1] = (ComparisonOperator) filterOperators;
//                    }
//                    List<ComparisonOperator> records = new ArrayList<>();
//                    records.add((ComparisonOperator) filterOperators);
//                    Map.Entry entr = new AbstractMap.SimpleEntry<>(comparisonOperators, records);
//                    hashMap.put(((ComparisonOperator) filterOperators).getFieldName(), entr);
//                }
//
//
//            }
//            else{
//                return;
//            }
//        });
//
//        hashMap.forEach((i,v)->{
//            if(v.getValue().size()>1){
//
//                FilterOperator filt;
//
//                if(v.getKey()[0] == null){
//                    filt = v.getKey()[1];
//                }
//                else if(v.getKey()[1] == null){
//                    filt = v.getKey()[0];
//                }
//                else if(Double.compare(new Double(String.valueOf(v.getKey()[0].getFieldValue())),new Double(String.valueOf(v.getKey()[1].getFieldValue()))) == -1){
//                    filt = Range.newRange(v.getKey()[0], v.getKey()[1]);
//                }
//                else{
//                    return;
//                }
//
//                List<ComparisonOperator> l =  v.getValue();
//                int indexOfReplacing = fopsList.indexOf(l.get(0));
//                fopsList.set(indexOfReplacing, filt);
//                for (int y = 1; y < l.size(); y++) {
//                    fopsList.remove(l.get(y));
//                }
//            }
//        });
//
//        setFilterOperatorChildren(fopsList.toArray(new FilterOperator[fopsList.size()]));

    }

    public static OperatorAnd newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    protected String setOperation() {
        return "SINTERSTORE";
    }

}
