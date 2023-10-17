--COUNTNONNULL( countNonNullValues )
--DOUBLE
CREATE OR REPLACE FUNCTION isNull(nulls int, val double)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(double)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;
--BOOLEAN
CREATE OR REPLACE FUNCTION isNull(nulls int, val boolean)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(boolean)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;
--STRING
CREATE OR REPLACE FUNCTION isNull(nulls int, val text)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(text)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;
--INTEGER
CREATE OR REPLACE FUNCTION isNull(nulls int, val int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(int)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;
--FLOAT
CREATE OR REPLACE FUNCTION isNull(nulls int, val float)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(float)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;
--SHORT
CREATE OR REPLACE FUNCTION isNull(nulls int, val smallint)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(smallint)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;
--LONG
CREATE OR REPLACE FUNCTION isNull(nulls int, val bigint)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(bigint)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;
--DATE
CREATE OR REPLACE FUNCTION isNull(nulls int, val date)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        if (val != null)
            nulls++;
        return nulls;
    $$;

CREATE OR REPLACE FUNCTION getNulls (nulls int)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return nulls;
    $$;

CREATE OR REPLACE AGGREGATE COUNTNULL(double)
    SFUNC isNull
    STYPE int
    FINALFUNC getNulls
    INITCOND 0;

--COUNTDISTINCT( countDistinctValues )
--DOUBLE
CREATE OR REPLACE FUNCTION isDistinct(distincts list<double>, val double)
    CALLED ON NULL INPUT
    RETURNS list<double>
    LANGUAGE java
    AS $$
        if(distincts.indexOf(val) == -1 || distincts.size() == 0)
            distincts.add(val);
        return distincts;
    $$;

CREATE OR REPLACE FUNCTION getDistinct (distincts list<double>)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return distincts.size();
    $$;

CREATE OR REPLACE AGGREGATE COUNTDISTINCT(double)
    SFUNC isDistinct
    STYPE list<double>
    FINALFUNC getDistinct
    INITCOND [];
--STRING
CREATE OR REPLACE FUNCTION isDistinct(distincts list<text>, val text)
    CALLED ON NULL INPUT
    RETURNS list<text>
    LANGUAGE java
    AS $$
        if(distincts.indexOf(val) == -1 || distincts.size() == 0)
            distincts.add(val);
        return distincts;
    $$;

CREATE OR REPLACE FUNCTION getDistinct (distincts list<text>)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return distincts.size();
    $$;

CREATE OR REPLACE AGGREGATE COUNTDISTINCT(text)
    SFUNC isDistinct
    STYPE list<text>
    FINALFUNC getDistinct
    INITCOND [];
--INTEGER
CREATE OR REPLACE FUNCTION isDistinct(distincts list<int>, val int)
    CALLED ON NULL INPUT
    RETURNS list<int>
    LANGUAGE java
    AS $$
        if(distincts.indexOf(val) == -1 || distincts.size() == 0)
            distincts.add(val);
        return distincts;
    $$;

CREATE OR REPLACE FUNCTION getDistinct (distincts list<int>)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return distincts.size();
    $$;

CREATE OR REPLACE AGGREGATE COUNTDISTINCT(int)
    SFUNC isDistinct
    STYPE list<int>
    FINALFUNC getDistinct
    INITCOND [];
--FLOAT
CREATE OR REPLACE FUNCTION isDistinct(distincts list<float>, val float)
    CALLED ON NULL INPUT
    RETURNS list<float>
    LANGUAGE java
    AS $$
        if(distincts.indexOf(val) == -1 || distincts.size() == 0)
            distincts.add(val);
        return distincts;
    $$;

CREATE OR REPLACE FUNCTION getDistinct (distincts list<float>)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return distincts.size();
    $$;

CREATE OR REPLACE AGGREGATE COUNTDISTINCT(float)
    SFUNC isDistinct
    STYPE list<float>
    FINALFUNC getDistinct
    INITCOND [];
--SHORT
CREATE OR REPLACE FUNCTION isDistinct(distincts list<smallint>, val smallint)
    CALLED ON NULL INPUT
    RETURNS list<smallint>
    LANGUAGE java
    AS $$
        if(distincts.indexOf(val) == -1 || distincts.size() == 0)
            distincts.add(val);
        return distincts;
    $$;

CREATE OR REPLACE FUNCTION getDistinct (distincts list<smallint>)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return distincts.size();
    $$;

CREATE OR REPLACE AGGREGATE COUNTDISTINCT(smallint)
    SFUNC isDistinct
    STYPE list<smallint>
    FINALFUNC getDistinct
    INITCOND [];
--LONG
CREATE OR REPLACE FUNCTION isDistinct(distincts list<bigint>, val bigint)
    CALLED ON NULL INPUT
    RETURNS list<bigint>
    LANGUAGE java
    AS $$
        if(distincts.indexOf(val) == -1 || distincts.size() == 0)
            distincts.add(val);
        return distincts;
    $$;

CREATE OR REPLACE FUNCTION getDistinct (distincts list<bigint>)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return distincts.size();
    $$;

CREATE OR REPLACE AGGREGATE COUNTDISTINCT(bigint)
    SFUNC isDistinct
    STYPE list<bigint>
    FINALFUNC getDistinct
    INITCOND [];
--DATE
CREATE OR REPLACE FUNCTION isDistinct(distincts list<date>, val date)
    CALLED ON NULL INPUT
    RETURNS list<date>
    LANGUAGE java
    AS $$
        if(distincts.indexOf(val) == -1 || distincts.size() == 0)
            distincts.add(val);
        return distincts;
    $$;

CREATE OR REPLACE FUNCTION getDistinct (distincts list<date>)
    CALLED ON NULL INPUT
    RETURNS int
    LANGUAGE java
    AS $$
        return distincts.size();
    $$;

CREATE OR REPLACE AGGREGATE COUNTDISTINCT(date)
    SFUNC isDistinct
    STYPE list<date>
    FINALFUNC getDistinct
    INITCOND [];