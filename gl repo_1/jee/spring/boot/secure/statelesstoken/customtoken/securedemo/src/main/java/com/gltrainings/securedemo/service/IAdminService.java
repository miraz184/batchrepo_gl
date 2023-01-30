package com.gltrainings.securedemo.service;

import com.gltrainings.securedemo.dto.AddAdmin;
import com.gltrainings.securedemo.dto.AdminDetails;

public interface IAdminService {
    AdminDetails register(AddAdmin requestData);
}
