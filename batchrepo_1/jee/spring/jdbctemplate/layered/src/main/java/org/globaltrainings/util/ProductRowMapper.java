package org.globaltrainings.util;

import org.globaltrainings.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
      int id =rs.getInt("id");
      double price=rs.getDouble("price");
      String name=rs.getString("name");
      Product product=new Product(id,name,price);
      return product;
    }
}
