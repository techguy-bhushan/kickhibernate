package com.kickwithhibernate.curd;

import com.kickwithhibernate.dao.BaseDAO;

/**
 * Created by bhushan on 28/3/17.
 */
public class CurdOperationTest {
    BaseDAO<Glass, Long> baseDAO = new BaseDAO<Glass, Long>();
    public static void main(String[] args) {
        CurdOperationTest curdOperationTest = new CurdOperationTest();
        // create Glass
        Glass glass = curdOperationTest.createGlass();
        // Show glass details after create.
        curdOperationTest.showGlass(glass);

        // Update glass
        glass.setColor("Green");
        glass.setWidth(2);
        glass.setHeight(3);
        glass = curdOperationTest.updateGlass(glass);

        // Show glass details after update.
        curdOperationTest.showGlass(glass);

        // Read glass value from database by glass ID
        curdOperationTest.read(glass.getId());

        // Delete Glass
        curdOperationTest.deleteGlass(glass);
    }

    public Glass createGlass() {
        Glass glass = new Glass();
        glass.setColor("RED");
        glass.setHeight(4);
        glass.setWidth(5);
        glass = baseDAO.save(glass);
        System.out.print("Successfully created Glass.");
        return glass;
    }

    public Glass updateGlass(Glass glass) {
        glass = baseDAO.save(glass);
        System.out.println("successfully updated glass");
        return glass;
    }

    public void deleteGlass(Glass glass) {
        baseDAO.delete(glass);
        System.out.println("successfully delete glass");
    }

    public void read(Long id) {
        Glass glass = baseDAO.findById(Glass.class, id);
        System.out.println(String.format("Glass id: %s",glass.getId()));
        System.out.println(String.format("Glass color: %s", glass.getColor()));
        System.out.println(String.format("Glass height: %s", glass.getHeight()));
        System.out.println(String.format("Glass width: %s", glass.getWidth()));
        System.out.println("Successfully read glass by id");
    }

    public void showGlass(Glass glass) {
        System.out.println(String.format("Glass id :%s, Color of glass is %s, width : %s and height : %s.", glass.getId(), glass.getColor(), glass.getWidth(), glass.getHeight()));
    }


}
