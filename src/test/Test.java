package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import db.serviceImpl.*;
import util.Convert;
import util.MySQLhelper;
import db.access.*;
import db.model.*;

public class Test {

    protected static void adminInsert() throws SQLException {
        System.out.println("������hasdsfsdfhaha");
        CrAdminDao crAdminDao = new CrAdminDao();
        CrAdmin crAdmin = new CrAdmin();
        crAdmin.setName("����");
        crAdmin.setId("2");
        crAdmin.setPassword("ly123");
        crAdmin.setMail("123@qq.com");
        crAdminDao.insert(crAdmin);
    }

    protected static void adminDelete() throws SQLException {
        CrAdminDao crAdminDao = new CrAdminDao();
        crAdminDao.delete("123");
    }

    protected static void admin() throws SQLException {
        CrAdminDao crAdminDao = new CrAdminDao();
//		String s = crAdminDao.findOne("123123", "324234").getName();
        List<CrAdmin> list = crAdminDao.findPage(1, 2);
        for (CrAdmin aAdmin : list)
            System.out.println(aAdmin.getName());

    }

    protected static void company() throws SQLException {
        CrCompanyRepre crCompanyRepre = new CrCompanyRepre();
        CrCompanyRepreDao crCompanyRepreDao = new CrCompanyRepreDao();
        crCompanyRepre = crCompanyRepreDao.findOne("2", "2");
        String s = (crCompanyRepre.getCompanyName());
        System.out.println(s);

    }

    protected static void fault() throws SQLException {
        CrFault crFault = new CrFault();
        CrFaultDao crFaultDao = new CrFaultDao();
        List<CrFault> list = crFaultDao.selectPage(2, 2);
//		crFaultDao.updateState("2", "2");

        for (CrFault obj : list) {
            System.out.println(obj.getFaultId());
        }
        crFault.setFaultId("222");
        crFault.setuserId("333");
        crFault.setAdminId("444");
        crFault.setBuilding("555");
        crFault.setRoomNumber("666");
        crFault.setContext("777");
//		crFaultDao.insert(crFault);

    }

    protected static void orderInfo() throws SQLException {
        CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
//		List<CrOrderInfo>list = crOrderInfoDao.selectPage(1, 2);
//		for(CrOrderInfo obj:list) {
//			System.out.println(obj.getReason());
        CrOrderInfo crOrderInfo = new CrOrderInfo();
        crOrderInfo.setUserId("2");
        crOrderInfo.setBuilding("����Ժ");
        crOrderInfo.setReason("����");
        int rst = crOrderInfoDao.InsertReturnOrderId(crOrderInfo);
        System.out.println(rst);
    }

    protected static void stringToTimestamp() throws SQLException {
        CrClassroomDao crClassroomDao = new CrClassroomDao();
        Timestamp t1 = Convert.stringToTimestamp("2013-2-3 00:00:00");
        Timestamp t2 = Convert.stringToTimestamp("2013-2-4 00:00:00");
        List<CrClassroom> list = crClassroomDao.findIdleClassroom(t1, t2, 1, 2);
        for (CrClassroom aClassroom : list) {
            System.out.println(aClassroom.getBuilding());
        }
    }

    public static void device() throws SQLException {
        CrSDeviceService crSDeviceService = new CrSDeviceService();
        List<CrSDevice> list = crSDeviceService.findDevice("��ʷ¥", "211");
        for (CrSDevice aDevice : list) {
            System.out.println(aDevice.getDeviceName());
            System.out.println(aDevice.getAvailableNum());
        }
    }

    public static void cancel() throws SQLException {
        CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
        List<CrOrderInfo> list = crOrderInfoDao.findPageOrderByUserId(2, 1, 5);
        for (CrOrderInfo aOrder : list) {
            System.out.println(aOrder.getOrderId());
            System.out.println(aOrder.getBuilding());
            System.out.println(aOrder.getRoomNumber());
        }
    }

    public static void checkState() throws SQLException {
        CrOrderInfoDao crOrderInfoDao = new CrOrderInfoDao();
        int state = crOrderInfoDao.checkReviewType("4");
        System.out.println(state);
    }

    public static void main(String[] args) throws SQLException {
        checkState();
    }

}
