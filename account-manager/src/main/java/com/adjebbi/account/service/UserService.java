package com.adjebbi.account.service;

import com.adjebbi.account.service.dto.UserInformation;

import java.util.Optional;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public interface UserService {

    Optional<UserInformation> getUserInformation(final String customerID);
}
