--NE( NotEqual )
CREATE OR REPLACE FUNCTION NE(field double, value double)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return field!=value;
$$;
CREATE OR REPLACE FUNCTION NE(field boolean, value boolean)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return field!=value;
$$;
CREATE OR REPLACE FUNCTION NE(field text, value text)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return !field.equals(value);
$$;
CREATE OR REPLACE FUNCTION NE(field int, value int)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return field!=value;
$$;
CREATE OR REPLACE FUNCTION NE(field float, value float)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return field!=value;
$$;
CREATE OR REPLACE FUNCTION NE(field smallint, value smallint)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return field!=value;
$$;
CREATE OR REPLACE FUNCTION NE(field bigint, value bigint)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return field!=value;
$$;
CREATE OR REPLACE FUNCTION NE(field date, value date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
return !field.equals(value);
$$;
--SPATIAL FUNCTIONS
--INCIRCLE( InCircle )
CREATE OR REPLACE FUNCTION INCIRCLE(longitude double, latitude double, lonvalue double, latvalue double, r double)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
        double dLat = Math.toRadians(latvalue - latitude);
        double dLon = Math.toRadians(lonvalue - longitude);

        // convert to radians
        latitude = Math.toRadians(latitude);
        latvalue = Math.toRadians(latvalue);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(latitude) *
                   Math.cos(latvalue);
        double rad = 6371000;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c <= r;
$$;
--INPOLY( InPolygon )
CREATE OR REPLACE FUNCTION INPOLY(longitude double, latitude double, points list<tuple<double,double>>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
//Ray cast algorithm
int counter = 0;
for(int i=0;i<points.size();i++){
    double p1Lat = points.get(i).getDouble(1);
    double p1Lon = points.get(i).getDouble(0);
    double p2Lat = points.get((i+1)%points.size()).getDouble(1);
    double p2Lon = points.get((i+1)%points.size()).getDouble(0);
    if((latitude<p1Lat != latitude<p2Lat) && longitude<p1Lon+((latitude-p1Lat)/(p2Lat-p1Lat))*(p2Lon-p1Lon)){
        counter++;
    }
}
return counter%2==1 && counter!=0;
$$;
--TEXTUAL FUNCTIONS
--ALL( AllKeywords where the field is a list of words)
CREATE OR REPLACE FUNCTION ALL(field list<text>, keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
    return field.containsAll(keywords);
$$;
--ANY( AnyKeywords where the field is a list of words
CREATE OR REPLACE FUNCTION ANY(field list<text>,keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
    return field.removeAll(keywords);
$$;
----ALL( AllKeywords where the field is a text)
CREATE OR REPLACE FUNCTION ALL(field text, keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
    String[] fieldWords = field.replace("\'","").split(" ");
    return Arrays.asList(fieldWords).containsAll(keywords);
$$;
--ANY( AnyKeywords where the field is a text)
CREATE OR REPLACE FUNCTION ANY(field text,keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
$$
    String[] fieldWords = field.replace("\'","").split(" ");
    return keywords.removeAll(Arrays.asList(fieldWords));
$$;
