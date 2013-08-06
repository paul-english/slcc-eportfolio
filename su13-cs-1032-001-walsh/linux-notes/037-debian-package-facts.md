---
layout: page
title:  Debian Package Facts
---

Debian packages are preconfigured installation packages similar to RPM
packages. Debian packages:

  * Are compatible with distributions that do not use RPMs, including Ubuntu, Knoppix, and Linspire.
  * Use naming conventions similar to RPM naming conventions, but use a .deb file extension.
  * Include dependency information.
  * Are not natively compatible with RPM.

The following table lists and describes several common commands for managing
Debian packages:

<table>

<tr> <td>Use...    </td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td> <b>dpkg </b></td> <td>Install Debian packages on Debian
distributions. Be aware of the following <b>dpkg</b> options:

<ul>

<li><b>-i </b>installs a package.

</li>

<li><b>\--configure </b>reconfigures an unpacked package.

</li>

<li><b>-r </b>removes the package but does not delete the configuration files.

</li>

<li><b>-P </b>completely uninstall the package including the configuration
files.

</li>

<li><b>-p </b>lists information about a currently installed Debian package.

</li>

<li><b>-I </b>(uppercase i)<b> </b>or <b>\--info </b>lists information about
packages that are not installed.

</li>

<li><b>-l </b>(lowercase L) displays all packages with names that match a
specified pattern.

</li>

<li><b>-L </b>shows the installed files for a package.

</li>

<li><b>-S </b>finds a package associated with specified files.

</li>

<li><b>-C </b>searches for packages that have been installed only partially on
the system.

</li>

<li><b>B </b>disables packages that have dependencies on the package being
removed.

</li>

<li><b>\--ignore-depends </b>ignores dependency-checking for specified
packages.

</li>

<li><b>-no-act </b>prevents changes from being written.

</li>

<li><b>-G </b>prevents a package from being installed if a newer version of
the package already exists on the computer.

</li>

<li><b>-E </b>does not install the package if the same version of the package
is already installed.

</li>

<li><b>-R</b> installs the package recursively.

</li>

</ul>

<b>Note</b>: The <b>dpkg-reconfigure</b> command reconfigures an already
installed package.

</td> <td><b>dpkg -i docbook_4.5-4_all.deb</b> installs the docbook
package.<b>  
dpkg -r docbook</b> removes the docbook package.  
<b>dpkg -P docbook</b> removes the docbook package and its configuration
files.  
<b>dpkg -i docbook</b> displays information about the package.  
<b>dpkg -I dwm-tools_26-2_i386.deb</b> displays information about the dwm-
tools package.  
<b>dpkg -l kcheckers*</b> lists all packages that begin with kcheckers.  
<b>dpkg -L docbook</b> lists all files installed with the docbook package.  
<b>dpkg -S /usr/share/base-files/motd</b> shows the package associated with
the motd file.  
<b>dpkg -B -r docbook</b> removes the docbook package and disables any package
dependant on the docbook package.  
<b>dpkg -G -i docbook_4.5-4_all.deb</b> installs the docbook package if it is
a newer version than a previously installed package. </td>

</tr>

<tr> <td> <b>apt-cache</b></td> <td>Retrieve information about the Debian
package database. Be aware of the following <b>apt-cache</b> options:

<ul>

<li><b>showpkg</b> displays information about a package in the database.

</li>

<li><b>stats </b>shows the number of packages installed, dependency
information, and other package cache statistics.

</li>

<li><b>unmet</b> lists any missing dependencies in the package cache.

</li>

<li><b>depends </b>shows all of the package¡¯s dependencies.

</li>

<li><b>pkgnames </b>displays whether a package is installed on the system.
When the package name is left off, the command shows information for all
packages on the computer.

</li>

<li><b>search </b>searches for a package in the cache.

</li>

</ul> </td> <td><b>apt-cache showpkg 3dchess_0.8.1-15_i386.deb </b>shows
information about the 3dchess package.  
<b>apt-cache depends 3dchess_0.8.1-15_i386.deb </b>shows dependency
information for the 3dchess package.  
<b>apt-cache pkgnames 3dchess </b>displays whether the 3dchess package is
installed.<b>  
apt-cache search kde </b>searches for all packages that contain kde anywhere
in the name.</td>

</tr>

<tr> <td><b>apt-get</b></td> <td>Download and install packages. <b>apt-
get:</b>

<ul>

<li>Is similar to the <b>yum</b> utility on an RPM distribution.

</li>

<li>Gets its information about the application repositories from the
<b>/etc/apt/sources.list</b> file.

</li>

</ul>

Be aware of the following <b>apt-get</b> options:

<ul>

<li><b>update </b>updates <b>/etc/apt/sources.list</b> with the latest
information about available packages.

</li>

<li><b>upgrade </b>upgrades all installed packages to the latest versions in
accordance with the information in <b>/etc/apt/sources.list</b>.

</li>

<li><b>dist-upgrade </b>shows all of the package¡¯s dependencies.

</li>

<li><b>install </b>installs a package using the package name. The package name
is not the file name. During the install, <b>apt-get</b> retrieves the most
recent version of the package.

</li>

<li><b>remove </b>removes a specified package, but leaves the configuration
files.

</li>

<li><b>\--purge</b> removes the package and the configuration files.

</li>

<li><b>source </b>retrieves the latest version of the package. The command
accesses the <b>/etc/apt/sources.list</b> file to determine whether the latest
package version is installed.

</li>

<li><b>check </b>checks the package database for consistency and errors.

</li>

<li><b>clean </b>removes unneeded package information files and logs. This
command is needed when not using the dselect utility to install Debian
packages.

</li>

<li><b>autoclean </b>removes information files about packages that can no
longer be downloaded.

</li>

<li><b>-d </b>downloads packages without installing them.

</li>

<li><b>-f </b>attempts to fix a computer with unsatisfied dependencies. Use
this with <b>apt-get install</b> and <b>apt-get remove</b>.

</li>

<li><b>-m </b>ignores package files that cannot be accessed or located.

</li>

<li><b>-q </b>shows less progress information.

</li>

<li><b>-s </b>simulates package installation without doing an actual install.

</li>

<li><b>-y </b>automatically provides a <i>yes</i> response to <i>yes / no</i>
questions in the package installation script.

</li>

</ul></td> <td><b>apt-get dist-upgrade 3dchess </b>shows dependency
information for the 3dchess package.<b>  
apt-get install 3dchess_0.8.1-15_i386.deb </b>installs the 3dchess package.  
<b>apt-get remove 3dchess </b>removes the 3dchess package.  
<b>apt-get source 3dchess </b>determines whether a newer version of 3dchess is
available, and if so, installs it.<b>  
apt-get -d install 3dchess_0.8.1-15_i386.deb </b>downloads the 3dchess package
without installing it.<b>  
apt-get -f install 3dchess_0.8.1-15_i386.deb </b>tries to fix dependency
issues for the 3dchess package.  
<b>apt-get -m remove 3dchess </b>removes the 3dchess package but ignores
missing files.  
<b>apt-get -q remove 3dchess </b>removes the 3dchess package but shows less of
the information during the process.  
<b>apt-get -s install 3dchess_0.8.1-15_i386.deb </b>tests the installation
process of the 3dchess package without installing it.  
<b>apt-get -y install 3dchess_0.8.1-15_i386.deb </b>installs the 3dchess
package and automatically provides a yes answer to any yes/no prompts.</td>

</tr>

<tr> <td><b>aptitude</b></td> <td>View the list of packages and perform
package management tasks such as installing, upgrading, and removing packages
in the Advanced Packaging Tool (APT). <b>aptitude</b> is the front-end to APT.
It displays a list of software packages and allows the user to interactively
pick packages to install or remove. </td> <td> </td>

</tr> </table>

