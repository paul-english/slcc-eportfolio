---
layout: page
title:  Rpm Facts
---

The Red Hat Package Manager (RPM) is a utility that installs application
packages. RPM:

  * Runs on SUSE, Red Hat, and Fedora distributions.
  * Installs and configures pre-compiled, pre-configured applications, and services on the system.
  * Accesses a library containing thousands of packages where the source code is built, compiled, and ready to be installed on a supported Linux architecture or distribution.
  * Installs, updates, verifies, queries, and uninstalls packages.
  * Uses a database stored at **/var/lib/rpm **that keeps track of all installed packages, their current status, and available updates.
  * Checks for dependencies on other packages and prompts to install these packages if necessary. A _dependency_ is an application's reliance on another package to perform correctly.

RPM uses a standard naming convention. Be aware of the following naming
convention details:

  * The syntax is _packagename_**-**_version_**-**_release_**.**_architecture.rpm_. 
  * Release numbers might contain distribution data:
    * **fcx** is for Fedora
    * **rhlx** is for Red Hat 
    * **suse**_xxx_ is for version _xxx_ of SUSE
  * The architecture type specifies the processor:
    * **i386** is for any Intel 80386 or newer processor.
    * **i586** is for any Intel Pentium I or newer processor.
    * **i686** is for any Intel Pentium II or newer processor.
    * **athlon** is for any AMD Athlon processor.
    * **noarch** is for any architecture (not architecture specific) 
  * For example, **acroread-8.1.3-51.6.i586.rpm** means the following:<table>
<tr> <td>Package Name</td> <td> Version Number</td> <td> Release</td> <td>
Architecture</td>

</tr>

<tr> <td>acroread </td> <td>8.1.3</td> <td>51.6 </td> <td>i586</td>

</tr> </table>

The following table lists and describes several common commands for managing
RPM packages:

<table>

<tr> <td>Use...</td> <td>To...</td> <td> Examples</td>

</tr>

<tr> <td><b>rpm</b></td> <td>Use the Red Hat Package Manager (RPM) to manage
packages. Be aware of the following options:

<ul>

<li><b>\--rebuilddb </b>rebuilds the database indices from the installed
package headers.

</li>

<li><b>\--initdb </b>creates a new database.

</li>

<li><b>\--checksig </b>checks the authenticity of the package. The option
checks the package's digital signing key against the package to ensure it has
not been altered.

</li>

<li><b>-i </b>installs a package. Use the entire package filename when
installing.

</li>

<li><b>-h </b>prints hash marks as the package archive is unpacked.

</li>

<li><b>-v</b> displays a verbose version of the installation.

</li>

<li><b>\--test </b>tests a package for uninstalled dependencies without
actually installing it.

</li>

<li><b>\--nodeps </b>installs the package without checking for dependencies.
This is not recommended.

</li>

<li><b>\--force </b>install the package regardless of whether, a newer version
of the package is already installed, package files overwrite files from
previously installed packages, or if the package replaces other installed
packages.

</li>

<li><b>-e </b>uninstalls (i.e., erases) a package. To uninstall a package, use
the package name, not the file name. If dependencies exist, the dependent
packages must first be removed.

</li>

<li><b>-U </b>updates an installed package to the newest version.

</li>

<li><b>-F</b> upgrades the package, but only if an earlier version currently
exists on the system.

</li>

<li><b>-q </b>queries the computer for information about installed packages.  
<b>Note:</b> Use this with <b>-a</b> to list all packages and <b>-l</b> show
the files associated with the package.

</li>

<li><b>-V </b>verifies that packages are free from errors by performing an MD5
checksum on the package. RPM only gives output when packages have errors. If
errors are present, the command displays the error code and the file name. The
error codes are:

<ul>

<li>S indicates a problem in size of a file.

</li>

<li>M indicates a problem with a file's mode.

</li>

<li>5 indicates a problem with the MD5 checksum of a file.

</li>

<li>D indicates a problem with a file's revision numbers.

</li>

<li>L indicates a problem with a file's symbolic link.

</li>

<li>U indicates a problem with a file's ownership.

</li>

<li>G indicates a problem with a file's group.

</li>

<li>T indicates a problem with the modification time of a file.

</li>

<li>c indicates the specified file is a configuration file.

</li>

<li>'<b>.</b>' in place of a code letter indicates that no error is present in
that area.

</li>

</ul>

</li>

</ul> </td> <td><b>rpm --checksig acroread </b>checks the authenticity of the
acroread package.<b>  
rpm -i BackupPC-3.1.0-3.fc9.src.rpm </b>installs the BackupPC package.  
<b>rpm -ihv http://rpm.sh-linux.org/rpm-fc9/target-
SRPMS/BackupPC-3.1.0-3.fc9.src.rpm </b>installs the specified package directly
from the Internet.  
<b>rpm -i --test dbus-python-0.83.0-2.fc9.src.rpm </b> tests the computer for
uninstalled dependencies for the dbus-python package.  
<b>rpm -i --nodeps dbus-python-0.83.0-2.fc9.src.rpm</b> installs the package
but does not check for missing dependencies.  
<b>rpm -i --force dbus-python-0.83.0-2.fc9.src.rpm</b> installs the package
regardless of effects on other packages.  
<b>rpm -e dbus-python </b>removes the package form the computer.  
<b>rpm -e --nodeps dbus-python </b>removes the package form the computer but
does not check for dependent packages.  
<b>rpm -U dbus-python-0.83.0-2.fc9.src.rpm </b>removes any version older than
the specified version and installs the specified package.  
<b>rpm -U --replacepkgs dbus-python-0.83.0-2.fc9.src.rpm </b>reinstalls the
dbus-python package. This option is for fixing errors.  
<b>rpm -qa</b> displays a list of all installed packages.  
<b>rpm -qi BackupPC</b> shows all available information about the BackupPC
package.  
<b>rpm -q --whatrequires gmp</b> lists the packages that are dependent on the
gmp package.  
<b>rpm -ql metacity</b> shows the files associated with the metacity package.  
<b>rpm -q --provides gmp</b> lists the functions that the gmp package
provides.  
<b>rpm -q --requires gmp</b> lists the functions that the gmp package
requires.  
<b>rpm -q --whatprovides /usr/lib/libstlport_gcc.so</b> shows the package that
provides the libstlport_gcc.so file.  
<b>rpm -V BackupPC</b> verifies the BackupPC package.  
<b>rpm -Va</b> verifies all installed packages.</td>

</tr>

<tr> <td> <b>rpm2cpio</b> </td> <td>Convert RPM packages into a cpio archive.
This is useful for extracting files from an RPM package without installing and
searching for the specific files.</td> <td> <b>rpm2cpio
logrotate-1.0-1.i386.rpm > logrotate.cpio </b>converts the files from the
<b>logrotate</b> package into a cpio archive.</td>

</tr> </table>

