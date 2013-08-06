---
layout: page
title:  Init Script Configuration Facts
---

Init script configuration is the process of specifying whether specific
daemons start at a specified runlevel. Init scripts:

  * Are configured differently for BSD (SUSE) and System V (Fedora and Red Hat) distributions.
  * Are stored in the following locations:
    * **/etc/rc.d/init.d** directory (System V distribution)
    * **/etc/init.d** directory (BSD distribution)
  * Have symbolic links that are stored in subdirectories that correspond to the runlevel under which each script should start.
  * Can be started and stopped manually.
  * Are started at boot using the init script. 
  * Have code in the scripts that determine the appropriate runlevels on which the script can operate. Configuration commands use this information to configure the appropriate levels at which scripts can start and stop. This code includes:
    * The default-start line defines the runlevels in which the script starts by default.
    * The required-start line defines services that must be running before this service can start
    * The should-start line defines the services that are recommended to start before this service starts.

Init script directories also contain other important scripts, including the
following:

  * _rc_ (BSD and System V) switches between runlevels.
  * _halt_ (BSD and System V) stops and reboots the computer. It runs when the ** init 0** or **init 6** commands are invoked.
  * _boot_ (BSD) or _rc.sysinit _(System V) is run by the init process when a computer starts. These scripts perform tasks that include:
    * Loading the kernel module
    * Checking the file system
    * Setting the system clock
  * _boot.local_ (BSD) or _rc.local_ (System V) runs specific tasks at startup as specified by the administrator.

When using init scripts, keep the following in mind:

  * At boot time, init uses the **/etc/inittab **file to determine the default runlevel, such as runlevel 5.
  * When a runlevel is specified, init looks at the directory associated with the runlevel to determine what processes to start. The directory for runlevel 5 is named rc5.d. Additional directories named rc0.d through rc6.d specify what processes to start for each runlevel. 
  * Each rc directory contains symbolic links that point to a specific init script:
    * Link names starting with an** S** start a script for the runlevel.
    * Link names starting with a **K** kill a running process when the computer changes runlevels.
  * Init follows the links and runs the scripts to start or stop processes.
  * Init repeats the process using the appropriate rc directory whenever the runlevel changes.

Use the following commands to manage daemons and the init scripts:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>service </b><i>daemon_name </i></td> <td>Manage the current state
of a daemon. Options include:

<ul>

<li><b>start </b>starts a daemon that is not currently running

</li>

<li><b>stop </b>halts a running daemon.

</li>

<li><b>restart </b>stops and restarts a daemon.

</li>

<li><b>reload</b> requests that a daemon read and apply its configuration
files without stopping.

</li>

<li><b>status </b>shows the status of a single daemon or daemons.

</li>

<li><b> \--status-all </b>shows the status of all daemons.

</li>

</ul>

<b>Note</b>: As an alternative method, use the absolute path to the daemon
script and the option to configure the daemon (e.g., <b>/etc/rc.d/init.d/httpd
stop</b>)

</td> <td> <b>service atd</b><i> </i><b>start </b>starts the atd daemon.<b>  
/etc/rc.d/init.d/httpd start</b> starts the httpd daemon.  
<b>service httpd</b><i> </i><b>stop </b>halts the httpd daemon.  
<b>/etc/rc.d/init.d/httpd restart </b>restarts the httpd daemon.  
<b>/etc/init.d/httpd reload </b>implements a new configuration for the httpd
daemon without halting the service.  
<b>service httpd reload </b>reloads the httpd daemon.  
<b>/etc/init.d/httpd status </b>shows whether the httpd daemon is running.  
<b>service --status-all </b>shows the status of all daemons. </td>

</tr>

<tr> <td><b>insserv</b></td> <td>Configure default runlevels for a daemon on a
BSD distribution. <b> insserv</b> references the INIT INFO script section of
each daemon to determine the default runlevels for the daemon and dependent
daemons. Be aware of the following options:

<ul>

<li><i><b>script_name</b> </i>starts at the runlevels specified in the init
block script code.

</li>

<li><b>-r</b><i> </i>keeps a script from starting at any runlevel.

</li>

<li><b>-d</b> restores a daemon to the default runlevels defined in the
scripts.

</li>

</ul> </td> <td><b>insserv httpd</b> causes the httpd daemon to start at the
runlevels specified in the script.<b>  
insserv -r httpd</b> stops the httpd daemon from starting when a computer
boots.</td>

</tr>

<tr> <td> <b>chkconfig</b></td> <td>Configure default runlevels for a daemon.
Be aware of the following options on a System V distribution:

<ul>

<li><b>\--add </b>adds a new service to be managed by <b>chkconfig</b>, and
makes sure the service has a start or kill entry at every runlevel.

</li>

<li><b>\--del</b> removes a service from <b>chkconfig</b> management, and
removes symbolic links to the service from /etc/rc<i>0-6</i>.d.

</li>

<li><b>\--level</b> <i>s</i>pecify the level to which a service should belong.

</li>

<li><b>\--level</b> <b>on|off|reset </b>starts, stops, or resets the named
service in the specified runlevel. The <b>on</b> and <b>off</b> options affect
levels 2, 3, 4, and 5 when the runlevel is omitted.

</li>

<li><b>\--list </b>lists of services and their runlevels.

</li>

</ul>

Be aware of the following options on a BSD distribution:

<ul>

<li><b>-l </b>lists services and their runlevels.

</li>

<li><b>-s</b> <i>s</i>pecify the level to which a service should belong.

</li>

</ul> </td> <td><b>chkconfig --add atd</b> starts the atd daemon.  
<b>chkconfig --del ldap</b> removes the ldap daemon.  
<b>chkconfig --level 5 lpd</b> specifies level 5 for the lpd daemon.  
<b>chkconfig --level 345 nfslock off</b> turns the nfslock daemon off in
runlevels 3, 4, and 5.  
<b>chkconfig ypxfrd on</b> turns the yp transfer daemon on in levels 2, 3, 4,
5.</td>

</tr> </table>

