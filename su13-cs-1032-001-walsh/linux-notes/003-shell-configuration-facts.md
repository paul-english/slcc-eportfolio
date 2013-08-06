---
layout: page
title:  Shell Configuration Facts
---

Shell configuration files are scripts that execute when a shell starts. The
shell type determines which shell configuration files are executed. Shell
types include:

  * _Login shells_ run when the system starts and is only using the Text User Interface (TUI) as the user interface. 
  * _Non-login shells _run when the system boots into a Graphical User Interface (GUI) and a user starts a terminal session. 

 The following are the names of the files used when the shell starts:

<table>

<tr> <td>Configuration File </td> <td>Description</td> <td>Used by shell
type</td>

</tr>

<tr> <td><b>~/.bashrc</b></td> <td><b>~/.bashrc </b>stores shell preferences
for individual users.</td> <td>non-login  
(login on some distributions)</td>

</tr>

<tr> <td><b>/etc/profile</b></td> <td><b>/etc/profile </b>stores system-wide
configuration commands and is used primarily to set environment variables.
</td> <td>login</td>

</tr>

<tr> <td><b>~/.bash_profile</b></td> <td><b>~/.bash_profile </b>stores shell
preferences for individual users.</td> <td>login</td>

</tr>

<tr> <td><b>~/.bash_login </b></td> <td><b>~/.bash_login </b>stores commands
that execute when a user logs in.</td> <td>login</td>

</tr>

<tr> <td><b>~/.profile</b></td> <td><b>~/.profile </b>stores configuration
preferences similar to <b>/etc/profile</b>, but for individual users.</td>
<td>login</td>

</tr>

<tr> <td><b>~/.bash_logout</b></td> <td><b>~/.bash_logout </b>stores commands
that execute when a user logs out.</td> <td>login</td>

</tr> </table>

Be aware of the following:

  * Login shells execute the configuration scripts they use in the following order:
    1. **/etc/profile**
    2. **~/.bash_profile **(If this file is found, the shell does not look for additional configuration script files)
    3. **~/.bash_login **(If this file is found, the shell does not look for additional configuration script files)
    4. **~/.profile **(This file only executes in the absence of the preceding two)
  * The **su -l** command switches to a user into a login shell; however, without the** -l** option, a non-login shell is started.

