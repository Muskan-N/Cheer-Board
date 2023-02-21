package service;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repo.RoleRepo;
import repo.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utility.ErrorUtility;
import utility.UtilityString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomUserDetailsService  {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    //mocking data in user table
//     void createUser(){
//        UserRepo.save(new UserRepo(1, 01, "muskan.singh@nagarro.com", "password", "muskan", true, " x");
//
//         LOGGER.log(Level.INFO, "user created");
//    }
    //finding user by email
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    //creating user
    public void saveUser(User user) {
        Role userRole = roleRepo.findByRole(utility.UtilityString.ADMIN);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setPassword(user.getPassword());
        if(userRole.equals(UtilityString.ADMIN)) {
            user.setEnabled(true);
        }
        userRepo.save(user);
    }


    //reading user
    public String readUserByName(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            user.getFullname();
            user.getRoles();
            return "" ;
        } else {
            throw new UsernameNotFoundException(ErrorUtility.USER_NOT_FOUND);
        }
    }





}
/*
{
    "statusCode" : [
            {
                "success" :
                    [
                        {"200":"The request has succeeded."},
                        {"201":"The request has been created."},
                        {"202":"The request has been accepted."},
                        {"204":"resource deleted successfully."},
                        {"205":"Reset content"}
                    ]
            },
            {
                "error":
                    [
                            {
                                "client":
                                    [
                                        {"401":"You are not authorized.kindly contact admin for details."},
                                        {"403":"Refresh the page."},
                                        {"404":"Request could not be found."},
                                        {"405":"Kindly Refresh or switch to different network"}
                                        {"402":"Too many requests,Kindly wait for a moment"}
                                    ]
            },
                            {
                                "server":
                                    [
                                        {"500":"Something unexpected happened on the web server"},
                                        {"501":"Server does not support the functionality required to fulfil the request."},
                                        {"502":"Restart your browser."},
                                        {"503":"Repeated application crashes."},
                                        {"504":"Time limit exceeded to load, Kindly switch to stable internet connection"},
                                        {"505":"HTTP Version not Supported,Kindly Switch to different browser"}
                                    ]
                            }
            }
        }*/
