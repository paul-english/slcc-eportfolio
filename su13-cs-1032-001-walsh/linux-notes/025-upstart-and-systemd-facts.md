---
layout: page
title:  Upstart And Systemd Facts
---

Upstart is an event-based replacement for the /sbin/init daemon; it will start
and stop tasks and services whenever the Linux system enters a specific
runlevel, but will also start and stop services upon receiving information
that something on the system has changed (known as an _event_).

  * Upstart runlevels are as follows:
    * **0 **= halt state
    * **1 **= single user mode
    * **2** = graphical, multi-user mode with networking (Default)
    * **3**, **4**, **5** = same as runlevel 2, but not used
    * **6** = reboot (the system restarts itself)
  * A _job_ is a series of instructions that init reads which typically include a program and the name of an event. The Upstart init daemon runs the program when the event is triggered. Jobs are divided into tasks and services.
    * A _task_ is a job that performs its work and returns to a waiting state when it is done.
    * A _service_ is a job that does not normally terminate by itself. The init daemon monitors each service, restarting the service if it fails and killing the service when it is stopped manually or by an event.
  * To run and stop a job manually, use the following commands: 
    * **start **starts a daemon that is not currently running
    * **stop **halts a running daemon.
    * **restart **stops and restarts a daemon.
    * **reload** requests that a daemon read and apply its configuration files without stopping.
    * **runlevel** displays the runlevel information. 
**Note**: Each of these commands are symbolic links to the **initctl** command. 
  * Traditionally, the default runlevel was encoded in the** /etc/inittab **file. However, with Upstart, this file is no longer used (it is supported by Upstart, but its use is deprecated).
  * To change the runlevel immediately, use one of the following commands:
    * **reboot**
    * **shutdown**
    * **telinit**
  * Use the **DEFAULT_RUNLEVEL** environment variable in** /etc/init/rc-sysinit.conf** to set the default runlevel.

Systemd is a replacement for both the /sbin/init daemon and upstart, and is
designed to allow services to be started in parallel at system startup. Be
aware of the following systemd details:

  * Systemd:
    * Is compatible with SysV and Linux Standards Base (LSB) init scripts
    * Uses socket and D-Bus activation for starting services
    * Allows you to start daemons on-demand
    * Tracks processes using Linux control groups
    * Supports snapshotting and restoring of the system state
  * Control groups (i.e., cgroups) are used to track processes (instead of process IDs) for systemd. cgroup details include:
    * A cgroup is a collection of processes that are bound together by common criteria. 
    * Cgroups are hierarchical. They are organized into parent-child relationships; a child group inherits parameters from its parent group. 
  * Use **systemctl** to manage services and runlevels. **systemctl** combines the functionality of both **service** and **chkconfig**.
  * The **/etc/systemd/system/default.target** symbolic link controls the default runlevel. It links to one of the files in the **/lib/systemd/system/ **directory, such as the following:
    * **default.target **(default file)
    * **multi-user.target** (runlevel 3)
    * **graphical.target** (runlevel 5)

