package com.ryerson.rentview.Business;

import com.ryerson.rentview.Helper.EncryptionUtil;
import com.ryerson.rentview.Helper.MemberInfo;
import com.ryerson.rentview.Persistence.Member_CRUD;

public class MemberManager {
    public static MemberInfo authenticateMember(String email, String password) {
        String storedPassword = Member_CRUD.getHashedPassword(email);
        if (storedPassword != null && storedPassword.equals(EncryptionUtil.hashPassword(email, password))) {
            return Member_CRUD.readMember(email);
        }
        return null;
    }
    public static void main(String[] args) {
        MemberInfo testEntity = authenticateMember("safhossain338@gmail.com", "helloWorld!");
        if (testEntity != null) {
            System.out.println(testEntity.toString());
        } else {
            System.out.println("Object is null");
        }
        MemberInfo testEntity2 = authenticateMember("BobJohn@example.com", "thebuilder85");
        if (testEntity2 != null) {
            System.out.println(testEntity2.toString());
        } else {
            System.out.println("Object is null");
        }
        MemberInfo testEntity3 = authenticateMember("safhossain338@gmail.com", "helloWorld!");
        if (testEntity3 != null) {
            System.out.println(testEntity3.toString());
        } else {
            System.out.println("Object is null");
        }
    }
}
