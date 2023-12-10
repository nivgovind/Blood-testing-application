/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.City;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shubhank
 */
public class CityDirectory {
    private List<City> cityList;

    public CityDirectory() {
        cityList = new ArrayList<City>();
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
    
    public City createAndAddCity(String name){
        City city = new City(name);
        city.setName(name);
        cityList.add(city);
        return city;
    }
}
