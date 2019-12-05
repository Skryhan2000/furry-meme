package com.loneliness.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface Entity {
    IntegerProperty getIntegerId();
    StringProperty getStringValue();
}
