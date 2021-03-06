package org.achartengine.model;

import java.util.Date;

public class TimeSeries extends XYSeries {
    public TimeSeries(String title) {
        super(title);
    }

    public synchronized void add(Date x, double y) {
        super.add((double) x.getTime(), y);
    }

    protected double getPadding() {
        return 1.0d;
    }
}
