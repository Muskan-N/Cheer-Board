package service;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repo.RoleRepo;
import repo.UserRepo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utility.ErrorUtility;
import utility.UtilityString;

@Service
public class CustomUserDetailsService  {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

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
                        {"200":},
                        {"201":},
                        {"202":},
                        {"203":},
                        {"204":},
                        {"205":}
                    ]
            },
            {
                "error":
                    [
                            {
                                "client":
                                    [
                                        {"400":},
                                        {"401":},
                                        {"402":},
                                        {"403":},
                                        {"404":},
                                        {"405":}
                                    ]
            },
                            {
                                "server":
                                    [
                                        {"500":},
                                        {"501":},
                                        {"502":},
                                        {"503":},
                                        {"504":},
                                        {"505":}
                                    ]
                            }
            }
        }*/
