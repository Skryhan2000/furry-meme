package com.loneliness.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface Entity {
    String getPrimaryStringId();
    IntegerProperty getIntegerId();
    StringProperty getStringValue();
}
