---
layout: page
title:  Yum Facts
---

The Yellowdog Updater Modified (YUM) is a robust utility that installs Red Hat
Package Manager (RPM) packages. YUM:

  * Is used on Red Hat, Fedora, and other compatible distributions. 
  * Checks the dependencies of the RPM packages, and automatically installs or updates any dependencies as needed.
  * Keeps and updates a file that lists all packages in Internet repositories.
  * Uses **/etc/yum.conf **as the configuration file. The configuration file contains:
    * URLs of RPM repositories.
    * Directories where it saves downloaded packages.
    * Locations of logs.
  * Uses** /etc/yum.repos.d/** to keep a .repo file for each Internet repository. To change where Linux looks for new or updated packages, add .repo files to this directory.
  * Uses **/var/usr/yum.log **as a log file to track when packages are installed, removed, or downloaded. 

The following table lists and describes several common commands for managing
RPM packages:

<table>

<tr> <td>Use...</td> <td>To...</td> <td> Example</td>

</tr>

<tr> <td><b>yum</b></td> <td> Install RPM packages included their
dependencies. Be aware of the following actions and options:

<ul>

<li><b>list </b>displays lists of packages.

</li>

<li><b>install </b>installs a package. Use the entire package filename when
installing.

</li>

<li><b>list updates </b>displays whether updates are available for packages.

</li>

<li><b>update </b>updates RPM packages.

</li>

<li><b>list available </b>lists packages that are available to install.

</li>

<li><b>search </b>searches all packages for a specified term.

</li>

<li><b>info </b>displays detailed package information.

</li>

<li><b>provides, whatprovides </b>displays what packages are associated with a
specific file.

</li>

<li><b>remove, erase </b>uninstalls a package.

</li>

<li><b>-y </b>bypasses confirmation prompts.

</li>

</ul> </td> <td><b>yum list all</b> shows all packages in the repository and
installed on the computer.  
<b>yum list javahelp2.noarch</b> searches for the javahelp2.noarch package in
the repository.  
<b>yum list *help*</b> lists all packages in the repository that have the
string help somewhere in the name.  
<b>yum list installed mtools.i686</b> shows whether the mtools.i686 package is
installed on the computer.<b>  
yum install BackupPC-3.1.0-3.fc9.src.rpm </b>installs the BackupPC package and
any package dependencies.  
<b>yum install http://rpm.sh-linux.org/rpm-fc9/target-
SRPMS/BackupPC-3.1.0-3.fc9.src.rpm </b> installs the specified package
directly from the Internet.  
<b>yum list update mtools.i686 </b>looks for an update for the mtools.i686
package and updates it if one is available.  
<b>yum update sssd.i686</b> updates the sssd.i686 package.  
<b>yum update</b> updates all installed packages.  
<b>yum list available</b> shows the available packages.  
<b>yum search Java </b>searches all package information and descriptions for
the term <i>Java</i>.  
<b>yum info zuff.i686</b> shows information about the zuff.i686 package.  
<b>yum whatprovides /etc/updatedb.conf </b>shows what packages are associated
with the updatedb.conf file.  
<b>yum remove kdegames.i686</b> uninstalls the kdegames.i686 package from your
computer.  
<b>yum -y update</b> updates all packages without requesting confirmation
prompts.</td>

</tr>

<tr> <td><b>yumdownloader</b> </td> <td>Download a package without installing
it.</td> <td><b>yumdownloader zuff.i686 </b> downloads the zuff package, but
does not install it.</td>

</tr>

<tr> <td> <b>createrepo</b> </td> <td>Create a repository list of RPM packages
stored locally or on a network. Be aware of the following options:

<ul>

<li><b>-g</b> specifies an xml file for the repository.

</li>

<li><b>-x</b> excludes specific file globs.

</li>

</ul> </td> <td> <b>createrepo -g</b> <b>packagefile.xml </b>creates a list of
packages using the .xml file </td>

</tr> </table>

