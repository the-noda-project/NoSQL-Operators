--NE( NotEqual )
CREATE OR REPLACE FUNCTION NE(field double, value double)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return field!=value;
';
CREATE OR REPLACE FUNCTION NE(field boolean, value boolean)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return field!=value;
';
CREATE OR REPLACE FUNCTION NE(field text, value text)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return !field.equals(value);
';
CREATE OR REPLACE FUNCTION NE(field int, value int)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return field!=value;
';
CREATE OR REPLACE FUNCTION NE(field float, value float)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return field!=value;
';
CREATE OR REPLACE FUNCTION NE(field smallint, value smallint)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return field!=value;
';
CREATE OR REPLACE FUNCTION NE(field bigint, value bigint)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return field!=value;
';
CREATE OR REPLACE FUNCTION NE(field date, value date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
return !field.equals(value);
';
--SPATIAL FUNCTIONS
--INCIRCLE( InCircle-Tuple )
CREATE OR REPLACE FUNCTION INCIRCLE(locationField tuple<double,double>, lat2 double, lon2 double, r double)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    double lat1 = locationfield.getDouble(0);
    double lon1 = locationfield.getDouble(1);
    double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(lat1) *
                   Math.cos(lat2);
        double rad = 6371000;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c <= r;
';
--INCIRCLE( InCircle-List )
CREATE OR REPLACE FUNCTION INCIRCLE(locationField list<double>, lat2 double, lon2 double, r double)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    double lat1 = locationfield.get(0);
    double lon1 = locationfield.get(1);
    double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(lat1) *
                   Math.cos(lat2);
        double rad = 6371000;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c <= r;
';
--INPOLY( InPolygon-Tuple )
CREATE OR REPLACE FUNCTION INPOLY(locationField tuple<double,double>, points list<tuple<double,double>>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double fieldlat = locationfield.getDouble(0);
double fieldlon = locationfield.getDouble(1);
//Ray cast algorithm
int counter = 0;
for(int i=0;i<points.size();i++){
    double p1Lat = points.get(i).getDouble(0);
    double p1Lon = points.get(i).getDouble(1);
    double p2Lat = points.get((i+1)%points.size()).getDouble(0);
    double p2Lon = points.get((i+1)%points.size()).getDouble(1);
    if((fieldlat<p1Lat != fieldlat<p2Lat) && fieldlon<p1Lon+((fieldlat-p1Lat)/(p2Lat-p1Lat))*(p2Lon-p1Lon)){
        counter++;
    }
}
return counter%2==1;
';
--INPOLY( InPolygon-List )
CREATE OR REPLACE FUNCTION INPOLY(locationField list<double>, points list<tuple<double,double>>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double fieldlat = locationfield.get(0);
double fieldlon = locationfield.get(1);
//Ray cast algorithm
int counter = 0;
for(int i=0;i<points.size();i++){
    double p1Lat = points.get(i).getDouble(0);
    double p1Lon = points.get(i).getDouble(1);
    double p2Lat = points.get((i+1)%points.size()).getDouble(0);
    double p2Lon = points.get((i+1)%points.size()).getDouble(1);
    if((fieldlat<p1Lat != fieldlat<p2Lat) && fieldlon<p1Lon+((fieldlat-p1Lat)/(p2Lat-p1Lat))*(p2Lon-p1Lon)){
        counter++;
    }
}
return counter%2==1;
';
--INRECT( InRectangle-Tuple )
CREATE OR REPLACE FUNCTION INRECT(locationField tuple<double,double>, lowerBound tuple<double,double>, upperBound tuple<double,double>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    double fieldlat = locationfield.getDouble(0);
    double fieldlon = locationfield.getDouble(1);
    double lowerLat = lowerbound.getDouble(0);
    double lowerLon = lowerbound.getDouble(1);
    double upperLat = upperbound.getDouble(0);
    double upperLon = upperbound.getDouble(1);
    return lowerLon<=fieldlon && fieldlon<=upperLon && lowerLat<=fieldlat && fieldlat<=upperLat;
';
--INRECT( InRectangle-List )
CREATE OR REPLACE FUNCTION INRECT(locationField list<double>, lowerBound tuple<double,double>, upperBound tuple<double,double>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    double fieldlat = locationfield.get(0);
    double fieldlon = locationfield.get(1);
    double lowerLat = lowerbound.getDouble(0);
    double lowerLon = lowerbound.getDouble(1);
    double upperLat = upperbound.getDouble(0);
    double upperLon = upperbound.getDouble(1);
    return lowerLon<=fieldlon && fieldlon<=upperLon && lowerLat<=fieldlat && fieldlat<=upperLat;
';
--GEO TEMPORAL FUNCTIONS
--INCIRCLETEMP( InCircleTemporal-Tuple )
CREATE OR REPLACE FUNCTION INCIRCLEMTEMP(locationField tuple<double,double> , lat2 double, lon2 double, r double, fieldDate date, lowerDate date, upperDate date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double lat1 = locationfield.getDouble(0);
double lon1 = locationfield.getDouble(1);
int lowerDays = lowerdate.getDaysSinceEpoch();
int fieldDays = fielddate.getDaysSinceEpoch();
int upperDays = upperdate.getDaysSinceEpoch();
//Check date boundary
    if(!((lowerDays<fieldDays)&&(fieldDays<upperDays))){
        return false;
    }
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);

    // convert to radians
    lat1 = Math.toRadians(lat1);
    lat2 = Math.toRadians(lat2);

    // apply formulae
    double a = Math.pow(Math.sin(dLat / 2), 2) +
               Math.pow(Math.sin(dLon / 2), 2) *
               Math.cos(lat1) *
               Math.cos(lat2);
    double rad = 6371000;
    double c = 2 * Math.asin(Math.sqrt(a));
    return rad * c <= r;
';
--INCIRCLETEMP( InCircleTemporal-List )
CREATE OR REPLACE FUNCTION INCIRCLEMTEMP(locationField list<double> , lat2 double, lon2 double, r double, fieldDate date, lowerDate date, upperDate date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double lat1 = locationfield.get(0);
double lon1 = locationfield.get(1);
int lowerDays = lowerdate.getDaysSinceEpoch();
int fieldDays = fielddate.getDaysSinceEpoch();
int upperDays = upperdate.getDaysSinceEpoch();
    //Check date boundary
    if(!((lowerDays<fieldDays)&&(fieldDays<upperDays))){
        return false;
    }
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);

    // convert to radians
    lat1 = Math.toRadians(lat1);
    lat2 = Math.toRadians(lat2);

    // apply formulae
    double a = Math.pow(Math.sin(dLat / 2), 2) +
               Math.pow(Math.sin(dLon / 2), 2) *
               Math.cos(lat1) *
               Math.cos(lat2);
    double rad = 6371000;
    double c = 2 * Math.asin(Math.sqrt(a));
    return rad * c <= r;
';
--INPOLYTEMP( InPolygonTemporal-Tuple )
CREATE OR REPLACE FUNCTION INPOLYTEMP(locationField tuple<double,double> , points list<tuple<double,double>>, fieldDate date, lowerDate date, upperDate date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double fieldlat = locationfield.getDouble(0);
double fieldlon = locationfield.getDouble(1);
int lowerDays = lowerdate.getDaysSinceEpoch();
int fieldDays = fielddate.getDaysSinceEpoch();
int upperDays = upperdate.getDaysSinceEpoch();
//Check date boundary
if(!((lowerDays<fieldDays)&&(fieldDays<upperDays))){
    return false;
}
//Ray cast algorithm
int counter = 0;
for(int i=0;i<points.size();i++){
    double p1Lat = points.get(i).getDouble(0);
    double p1Lon = points.get(i).getDouble(1);
    double p2Lat = points.get((i+1)%points.size()).getDouble(0);
    double p2Lon = points.get((i+1)%points.size()).getDouble(1);
    if((fieldlat<p1Lat != fieldlat<p2Lat) && fieldlon<p1Lon+((fieldlat-p1Lat)/(p2Lat-p1Lat))*(p2Lon-p1Lon)){
        counter++;
    }
}
return counter%2==1;
';
--INPOLYTEMP( InPolygonTemporal-List )
CREATE OR REPLACE FUNCTION INPOLYTEMP(locationField list<double> , points list<tuple<double,double>>, fieldDate date, lowerDate date, upperDate date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double fieldlat = locationfield.get(0);
double fieldlon = locationfield.get(1);
int lowerDays = lowerdate.getDaysSinceEpoch();
int fieldDays = fielddate.getDaysSinceEpoch();
int upperDays = upperdate.getDaysSinceEpoch();
//Check date boundary
if(!((lowerDays<fieldDays)&&(fieldDays<upperDays))){
    return false;
}
//Ray cast algorithm
int counter = 0;
for(int i=0;i<points.size();i++){
    double p1Lat = points.get(i).getDouble(0);
    double p1Lon = points.get(i).getDouble(1);
    double p2Lat = points.get((i+1)%points.size()).getDouble(0);
    double p2Lon = points.get((i+1)%points.size()).getDouble(1);
    if((fieldlat<p1Lat != fieldlat<p2Lat) && fieldlon<p1Lon+((fieldlat-p1Lat)/(p2Lat-p1Lat))*(p2Lon-p1Lon)){
        counter++;
    }
}
return counter%2==1;
';
--INRECTEMP( InRectangleTemporal-Tuple )
CREATE OR REPLACE FUNCTION INRECTTEMP(locationField tuple<double,double> , lowerBound tuple<double,double>, upperBound tuple<double,double>, fieldDate date, lowerDate date, upperDate date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double fieldlat = locationfield.getDouble(0);
double fieldlon = locationfield.getDouble(1);
int lowerDays = lowerdate.getDaysSinceEpoch();
int fieldDays = fielddate.getDaysSinceEpoch();
int upperDays = upperdate.getDaysSinceEpoch();
//Check date boundary
if(!((lowerDays<fieldDays)&&(fieldDays<upperDays))){
    return false;
}
double lowerLat = lowerbound.getDouble(0);
double lowerLon = lowerbound.getDouble(1);
double upperLat = upperbound.getDouble(0);
double upperLon = upperbound.getDouble(1);
return lowerLon<=fieldlon && fieldlon<=upperLon && lowerLat<=fieldlat && fieldlat<=upperLat;
';
--INRECTEMP( InRectangleTemporal-List )
CREATE OR REPLACE FUNCTION INRECTTEMP(locationField list<double> , lowerBound tuple<double,double>, upperBound tuple<double,double>, fieldDate date, lowerDate date, upperDate date)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
double fieldlat = locationfield.get(0);
double fieldlon = locationfield.get(1);
int lowerDays = lowerdate.getDaysSinceEpoch();
int fieldDays = fielddate.getDaysSinceEpoch();
int upperDays = upperdate.getDaysSinceEpoch();
//Check date boundary
if(!((lowerDays<fieldDays)&&(fieldDays<upperDays))){
    return false;
}
double lowerLat = lowerbound.getDouble(0);
double lowerLon = lowerbound.getDouble(1);
double upperLat = upperbound.getDouble(0);
double upperLon = upperbound.getDouble(1);
return lowerLon<=fieldlon && fieldlon<=upperLon && lowerLat<=fieldlat && fieldlat<=upperLat;
';
--TEXTUAL FUNCTIONS
--ALL( AllKeywords where the field is a list of words)
CREATE OR REPLACE FUNCTION ALL(field list<text>, keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    return field.containsAll(keywords);
';
--ANY( AnyKeywords where the field is a list of words
CREATE OR REPLACE FUNCTION ANY(field list<text>,keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    return field.removeAll(keywords);
';
----ALL( AllKeywords where the field is a text)
CREATE OR REPLACE FUNCTION ALL(field text, keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    String[] fieldWords = field.split(" ");
    return keywords.containsAll(Arrays.asList(fieldWords));
';
--ANY( AnyKeywords where the field is a text)
CREATE OR REPLACE FUNCTION ANY(field text,keywords list<text>)
RETURNS NULL ON NULL INPUT RETURNS boolean
LANGUAGE java AS
'
    String[] fieldWords = field.split(" ");
    return keywords.removeAll(Arrays.asList(fieldWords));
';
