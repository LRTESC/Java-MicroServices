package com.groupe2.rent.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public abstract class AbstractDaoImpl {

    @Autowired
    @Qualifier("dataSourceTicket")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }
}
