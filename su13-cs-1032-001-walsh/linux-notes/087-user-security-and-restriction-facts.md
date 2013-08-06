---
layout: page
title:  User Security And Restriction Facts
---

When considering user security, keep in mind the following:

  * Users should be trained to use secure passwords. Secure passwords use numbers and letters, and are more than 7 characters in length.
  * Passwords should expire periodically, but not too often.
  * Administrators can limit the resources that user can access.

The following table describes commands used to promote user security and
restrictions:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td>Examples</td>

</tr>

<tr> <td> <b>chage</b></td> <td>Set user passwords to expire. Be aware of the
following options:

<ul>

<li><b>-M</b> sets the maximum number of days before the password expires.

</li>

<li><b>-W</b> sets the number of days before the password expires that a
warning message displays.

</li>

<li><b>-m</b> sets the minimum number of days that must pass after a password
has been changed before a user can change the password again.

</li>

</ul>

<b>Note:</b> Look in the <b>/etc/shadow</b> file to see current limits for
users.

</td> <td><b>chage -M 60 -W 10 jsmith</b> sets the password for <i>jsmith</i>
to expire after 60 days and gives a warning 10 days before it expires.</td>

</tr>

<tr> <td><b>ulimit</b></td> <td>Limit computer resources used for applications
launched from the shell. Limits can be hard of soft limits. Soft limits can be
temporarily exceeded up to the hard limit setting. Users can modify soft
limits, but only root can modify hard limits.

Options include:

<ul>

<li><b>-c</b> limits the size of a core dump file. The value is in blocks.

</li>

<li><b>-f</b> limits the file size of files created using the shell session.
The value is in blocks.

</li>

<li><b>-n</b> limits the maximum number of open files.

</li>

<li><b>-t</b> limits the amount of CPU time a process can use. This is set in
seconds.

</li>

<li><b>-u</b> limits the number of concurrent processes a user can run.

</li>

<li><b>-d</b> limits the maximum amount of memory a process can use. The value
is in kilobytes.

</li>

<li><b>-H</b> sets a hard resource limit.

</li>

<li><b>-S</b> sets a soft resource limit.

</li>

<li><b>-a</b> displays current limits. The default shows soft limits.

</li>

</ul> </td> <td><b>ulimit -H -f 1024</b> uses a hard limit to limit the size
of files to 1020 KB.  
<b>ulimit -H -a</b> shows current hard limits.  
<b>ulimit -a</b> shows the current soft limits.  
<b>ulimit -S -u 10</b> sets a soft limit that limits the number of processes
that a single user can use to 10.  
<b>ulimit -t 600</b> limits CPU time for a process to 10 minutes. This sets
both hard and soft limits.  
<b>ulimit -d unlimited</b> removes all restrictions for process memory
usage.</td>

</tr> </table>

Use the** /etc/security/limits.conf **file to limit resource use for all
applications. This file is from the _pam_limits_ module of the Plugable
Authentication Modules (PAM) module set. Entries in
**/etc/security/limits.conf** use the following syntax:

> _Entity    Type    Limit    Value_

The following table describes the entry options in the
**/etc/security/limits.conf **file:

<table>

<tr> <td>Entity</td> <td>Type</td> <td>Limits</td> <td>Value</td>

</tr>

<tr> <td>When specifying the Entity:

<ul>

<li>Specify a single user with a user name.

</li>

<li>Use an ampersand (@) to specify a group.

</li>

<li>Use an asterisk (*) as a wildcard.

</li>

</ul> </td> <td>For the Type:

<ul>

<li>Use <b>hard</b> to set a limit that cannot be exceeded.

</li>

<li>Use <b>soft</b> to set a limit that can be exceeded temporarily.

</li>

</ul>



</td> <td>Limits include:

<ul>

<li><b>core</b> limits the size of core dump files. The value uses kilobytes.

</li>

<li><b>data</b> limits the amount of ram an application can use. The value
uses kilobytes.

</li>

<li><b>fsize</b> limits maximum file size. The value uses kilobytes.

</li>

<li><b>nofile</b> limits the number of concurrently open data files.

</li>

<li><b>cpu</b> limits the amount of CPU time a process can use. The value uses
minutes.

</li>

<li><b>nproc</b> limits the number of concurrent processes a user can have.

</li>

<li><b>maxlogins</b> limits the number of concurrent logins.

</li>

<li><b>priority</b> sets process priority limits. The value range is from -20
(highest priority) to 19 (lowest priority) with 0 being the default.

</li>

<li><b>rss</b> limits the total amount of memory a user can use. The value
uses kilobytes.

</li>

</ul> </td> <td>Values include integers, such as 1, 5, or 3000.</td>

</tr> </table>

The following are examples of entries in the **/etc/security/limits.conf
**file:

<table>

<tr> <td>Example</td> <td>Description</td>

</tr>

<tr> <td><b>jsmith        hard    fsize             1024</b></td> <td>Limits
the maximum file size that <i>jsmith</i> can create to 1024 KB.</td>

</tr>

<tr> <td><b>@guests    hard    maxlogins    3</b></td> <td>Limits the number
of concurrent logins from the <i>guest</i> group to three.</td>

</tr>

<tr> <td> <b>*                hard    maxlogins    1</b></td> <td>Limits
concurrent logins from the same user to one.</td>

</tr>

<tr> <td> <b>*                soft      cpu              10</b> </td> <td>Sets
a soft limit of 10 minutes on the amount of CPU time any single process for
any user can take.</td>

</tr>

<tr> <td><b>rss             hard    rss                5000</b></td>
<td>Limits the total amount of memory available to a single user to 5 MB </td>

</tr> </table>

