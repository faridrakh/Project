package com.brs.project.common.controller;

import com.brs.project.common.model.DataContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController {
    protected DataContainer dataContainer;

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    @Autowired
    public void setDataContainer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }
}
