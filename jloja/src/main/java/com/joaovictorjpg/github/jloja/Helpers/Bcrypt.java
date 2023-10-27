package com.joaovictorjpg.github.jloja.Helpers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.joaovictorjpg.github.jloja.model.entities.User;

public class Bcrypt {

    public static String brycptPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean correctPassword (String password, User user) {
        return BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()).verified;
    }

}
