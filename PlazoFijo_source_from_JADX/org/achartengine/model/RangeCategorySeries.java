package org.achartengine.model;

import java.util.ArrayList;
import java.util.List;

public class RangeCategorySeries extends CategorySeries {
    private List<Double> mMaxValues;

    public RangeCategorySeries(String title) {
        super(title);
        this.mMaxValues = new ArrayList();
    }

    public synchronized void add(double minValue, double maxValue) {
        super.add(minValue);
        this.mMaxValues.add(Double.valueOf(maxValue));
    }

    public synchronized void add(String category, double minValue, double maxValue) {
        super.add(category, minValue);
        this.mMaxValues.add(Double.valueOf(maxValue));
    }

    public synchronized void remove(int index) {
        super.remove(index);
        this.mMaxValues.remove(index);
    }

    public synchronized void clear() {
        super.clear();
        this.mMaxValues.clear();
    }

    public double getMinimumValue(int index) {
        return getValue(index);
    }

    public double getMaximumValue(int index) {
        return ((Double) this.mMaxValues.get(index)).doubleValue();
    }

    public XYSeries toXYSeries() {
        XYSeries xySeries = new XYSeries(getTitle());
        int length = getItemCount();
        for (int k = 0; k < length; k++) {
            xySeries.add((double) (k + 1), getMinimumValue(k));
            xySeries.add(((double) k) + 1.000001d, getMaximumValue(k));
        }
        return xySeries;
    }
}
