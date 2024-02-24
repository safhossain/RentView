package com.ryerson.rentview.Business;

import com.ryerson.rentview.Helper.MemberInfo;
import com.ryerson.rentview.Persistence.Member_CRUD;

public class MemberManager {
    public static MemberInfo authenticateMember(String email, String password) {
        String storedPassword = Member_CRUD.getHashedPassword(email);
        if (storedPassword != null && storedPassword.equals(password)) {
            return Member_CRUD.readMember(email);
        }
        return null;
    }
//    public static void main(String[] args) {
//        MemberInfo testEntity = authenticateMember("s2hossain@torontomu.ca", "helloWorld!");
//        if (testEntity != null) {
//            System.out.println(testEntity.toString());
//        } else {
//            System.out.println("Object is null");
//        }
//    }
}
