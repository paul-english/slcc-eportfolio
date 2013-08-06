---
layout: page
title:  Login Blocking Facts
---

Administrators can prevent (i.e., block) users from logging in to a Linux
computer while resolving serious issues, and can display a message to users
attempting to log in. Login blocking is enabled using the Pluggable
Authentication Modules (PAM) module configured in the **/etc/pam.d/login
**file. PAM:

  * Is a set of modules that enables various authentication systems on a Linux computer. 
  * Can employ modules concurrently. For example, one PAM module can be used to enable biometric logins while another enables standard user/password authentication. 

The following list describes the tasks necessary to configure login blocking:

  * Force all users to log out of the system:
    1. Log in directly as the _root_ user.
    2. Use the **w** command to view all active user accounts.
    3. Use **pkill -KILL -u _user_ **to force the user to log out for each active user.
  * Disable the ability to login to the system:
    1. Create the **/etc/nologin** file.
    2. Add a message to the file to display to users when they attempt to log in.
**Note**: Rename or delete the file to re-enable logins.
  * Add the following line to the **/etc/pam.d/login** file to configure the PAM module to verify whether the file** /etc/nologin** exists:  
  
**        auth requisite pam_nologin.so**

> **Note**: If **/etc/nologin **does exist and the user is not _root_,
authentication fails.

