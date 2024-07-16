/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84362
 */
public class UserService {
    private final String filePath = "user.txt";
    private List<User> userList;
    private User user;

    public UserService() {
    }

    
    
    public void getUserList() {
        try{
            userList = getUserListFromFile(filePath);
        }catch(Exception ex){
            ex.printStackTrace();
        }
//        for(var user : userList){
//            System.out.println(user.toString());
//        }
    }

    public User getUser() {
        return user;
    }
    
    
    private List<User> getUserListFromFile(String filePath) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        userList = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null){
            if(line.startsWith("User{") && line.endsWith("}")){
                line = line.substring(5,line.length()-1);
                String[] items = line.split(",");
                String userName=null;
                String password=null;
                for(String item : items){
                    String[] parts = item.split("=");
                    if(parts.length == 2){
                        if(parts[0].trim().equals("userName")){
                            userName = parts[1];
                        }else if(parts[0].trim().equals("password")){
                            password = parts[1];
                        }
                    }
                }
                userList.add(new User(userName,password));
            }
        }
        reader.close();
        return userList;
    }
    
    public boolean checkUser(String userName, String password){
        boolean checkPoint = false;
        getUserList();
        for(User user : userList){
            if(user.userName.equals(userName) && user.password.equals(password)){
                checkPoint = true;
            }
        }
        return checkPoint;
    }
}
