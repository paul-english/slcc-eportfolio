---
layout: page
title:  User And Group Facts
---

_User_ accounts control the ability to log on to a system, access resources,
and perform certain actions. _Groups_ provide a means of grouping users for
administrative purposes such as assigning permissions to files. Be aware of
the following types of users and groups:

<table>

<tr> <td><b>Type</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>Standard user</td> <td>Standard user accounts can log into the
system. Standard user accounts:

<ul>

<li>Have friendly usernames (such as <i>mary</i> or <i>bkaun</i>). An
administrator must create the user names.

</li>

<li>Have an ID of 500 or more for Fedora, or 1000 or more for SUSE. The ID is
automatically assigned by the system when the account is created.

</li>

</ul> </td>

</tr>

<tr> <td>System user</td> <td>System user accounts are created by default
during the Linux installation and are used by the system for specific roles.
System user accounts:

<ul>

<li>Have names that correspond with their roles, such as <i>ftp</i> and
<i>mail</i>.

</li>

<li>Cannot be used to log into the system.

</li>

</ul>

<b>Note</b>: The <i>root</i> user account is created by default and has a UID
of 0; however, it can be used to log into a system and perform tasks.

</td>

</tr>

<tr> <td>Primary group</td> <td>Primary groups (also called the private group)
are created when a standard user is created. Primary groups:

<ul>

<li>Have the corresponding user as the only member.

</li>

<li>Are automatically made the owner of files and directories when they are
created.

</li>

<li>Are similar to any other group; however, the only difference is that the
user account specifically identifies the primary group for each user.

</li>

</ul> </td>

</tr>

<tr> <td>Secondary groups</td> <td>Secondary groups are used to manage access
to files and directories. Secondary groups:

<ul>

<li>Have friendly names (such as <i>sales </i>or <i>accounting</i>). An
administrator must assign secondary group names.

</li>

<li>Receive their membership as assigned by the system administrator.

</li>

</ul> </td>

</tr> </table>

The user and group databases are stored in the following files:

<table>

<tr> <td><b>File</b></td> <td><b>Description</b></td>

</tr>

<tr> <td><b>/etc/passwd</b></td> <td>The <b>/etc/passwd</b> file holds user
account information. Be aware of the following details:

<ul>

<li>Each entry identifies a user account.

</li>

<li>Each entry contains multiple fields, with each field separated by a colon.

</li>

</ul>

The following line is a sample entry in the <b>/etc/passwd</b> file:

> pclark:x:501:501:Petunia Clark:/home/pclark:/bin/bash

The fields within this line are as follows:

<ol>

<li>User account name.

</li>

<li>Password. An x in the field indicates passwords are stored in the
<b>/etc/shadow</b> file.

</li>

<li>User ID number.

</li>

<li>Primary group ID number (also known as the default group ID number).
Typically this number matches the UID number.

</li>

<li>GECOS field. This field is typically used for a description or the user's
full name.

</li>

<li>Path to the home directory.

</li>

<li>Path to the default shell.

</li>

</ol> </td>

</tr>

<tr> <td><b>/etc/shadow</b></td> <td>The <b>/etc/shadow</b> file holds
passwords and password expiration information for user accounts. Be aware of
the following details:

<ul>

<li>Using the <b>/etc/shadow</b> file to separate usernames from passwords
increases the security of the user passwords.

</li>

<li>Like the<b> /etc/passwd</b> file, each entry corresponds to a user account
and each entry contains multiple fields, with each field separated by a colon.

</li>

</ul>

The following line is a sample entry in the <b>/etc/shadow</b> file:

> pclark:$ab7Y56gu9bs:12567:0:99999:7:::

The fields within this line are as follows:

<ol>

<li>User account name.

</li>

<li>Password.

<ul>

<li>$ preceding the password identifies the password as an encrypted entry.

</li>

<li>! or !! indicates the account is locked and cannot be used to log in.

</li>

<li>* indicates a system account entry and cannot be used to log in.

</li>

</ul>

</li>

<li>Last change. The date of the most recent password change, measured in the
number of days since 1 January 1970.

</li>

<li>Minimum password age. The minimum number of days the user must wait before
changing the password.

</li>

<li>Maximum password age. The maximum number of days between password changes.

</li>

<li>Password change warning. The number of days a user is warned before the
password must be changed.

</li>

<li>Grace logins. The number of days the user can log in without changing the
password.

</li>

<li>Disable time. The number of days since 1 January 1970, after which the
account will be disabled.

</li>

</ol> </td>

</tr>

<tr> <td><b>/etc/group</b></td> <td>The <b>/etc/group </b>file holds group
information including the group name, GID, and group membership information.
Be aware of the following details:

<ul>

<li>Each entry identifies a group.

</li>

<li>Each entry contains multiple fields, with each field separated by a colon.

</li>

</ul>

The following line is a sample entry in the <b>/etc/group</b> file:

> sales:x:510:pclark,mmckay,hsamson

The fields within this line are as follows:

<ol>

<li>Group name.

</li>

<li>Group password. An x indicates the group passwords are contained in the
<b>/etc/gshadow</b> file.

</li>

<li>Group ID.

</li>

<li>Group members. Contains a comma-separated list of user accounts that are
members of the group.

</li>

</ol> </td>

</tr>

<tr> <td><b>/etc/gshadow</b></td> <td>The <b>/etc/gshadow</b> file holds
passwords for groups.  Be aware of the following details:

<ul>

<li>Like the /etc/group file, each line corresponds to a group.

</li>

<li>Each line consists of fields separated by colons.

</li>

</ul>

The following line is a sample entry in the <b>/etc/gshadow </b>file:

sales:!:pclark:pclark,mmckay,hsamson

The fields within this line are as follows:

<ol>

<li>Group name.

</li>

<li>Group password. The group password allows users to add themselves as
members of the account.

<ul>

<li>If the field contains a single exclamation point (!), the group account
cannot be accessed using the password.

</li>

<li>If the field contains a double exclamation point (!!), no password has
been assigned to the group account (and it cannot be accessed using the
password).

</li>

<li>If there is no value, only group members can log in to the group account.

</li>

</ul>

</li>

<li>Administrators. Contains a comma-separated list of users who have
authorization to administer the account.

</li>

<li>Group members. Contains a comma-separated list of user accounts that are
members of the group.

</li>

</ol> </td>

</tr> </table>

**Note**: Be aware of the following details:

  * User and group account information can also be managed through the following network services. Each service can query network servers for user authentication parameters, such as usernames and passwords.
    * OpenLDAP is an open source implementation of the Lightweight Directory Access Protocol (LDAP). 
    * Network Information System (NIS) allows many Linux computers to share a set of username and password parameters.
    * Windows Domain allows access to a central directory database that stores security and user account information.
  * The **pwck** command verifies the entries in the **/etc/passwd** and ** /etc/shadow** files. Errors are displayed on the screen, and entries may be deleted to solve the errors.
  * The **pwconv** command synchronizes the entries in the **/etc/passwd** and **/etc/shadow** files.

