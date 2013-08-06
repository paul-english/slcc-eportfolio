---
layout: page
title:  Tar Facts
---

The **tar** (tape archive) utility takes the contents of several files and
stores them as a single file. Tar:

  * Uses the .tar file extension.
  * Can backup entire directories or file systems.

The following table lists several options that tar uses.

<table>

<tr> <td>Use...</td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>tar</b></td> <td>Combine multiple files into a single file.
Options include:

<ul>

<li><b>-c </b>creates a new archive.

</li>

<li><b>-v </b>displays a list of all files being written into the archive.

</li>

<li><b>-f </b>specifies the file to create or unpack. Without this option tar
uses standard input and output as the destination.

</li>

<li><b>-x </b>extracts the files. If no destination directory is specified,
then tar extracts the files to the current working directory.

</li>

<li><b>-z </b>compresses/decompresses a file using the <b>gzip</b> utility
(normally named with a .gz extension).

</li>

<li><b>-j </b>compresses/decompresses a file using the <b>bzip2</b> utility
(normally named with a .bz2 extension).

</li>

<li><b>-C </b>changes to a specific directory to extract the files.

</li>

<li><b>-t </b>lists the contents of an archive.

</li>

</ul> </td> <td><b>tar -cf /root/tarbackups/oct17backup.tar /home</b> writes a
backup of the /home directory to the <b>/root/tarbackups/oct17backup.tar
</b>file.  
<b>tar -cvf /root/tarbackups/oct17backup.tar /home</b> writes a backup of the
/home directory to the <b>/root/tarbackups/oct17backup.tar </b> file.  
<b>tar -cvf /root/tarbackups/oct17backup.tar /home</b> writes a backup of the
/home directory to the <b>/root/tarbackups/oct17backup.tar </b> file.  
<b>tar -xvf /root/tarbackups/oct17backup.tar -C /home</b> extracts the files
and decompresses them to the<b> /home </b>directory. </td>

</tr>

<tr> <td><b>gzip</b></td> <td>Compress a file using <b>gzip</b>. Options
include:

<ul>

<li><b>-c </b>writes the file to standard output.

</li>

<li><b>-d</b> decompresses the file.

</li>

<li><b>-l</b> displays information about files in an archive.

</li>

<li><b>-r</b> recursively compresses all files in directories and
subdirectories.

</li>

</ul>

<b>Note:</b> This is the same as the <b>tar -z </b>command.

</td> <td><b>gzip file.tar</b> creates a compressed file and removes the
original file.  
<b>gzip -c file.tar > file.tar.gz </b>creates a tar archive<b> </b> leaving
the original file unchanged.<b>  
gzip -d </b> <b>file.tar.gz </b>uncompresses the tar archive. </td>

</tr>

<tr> <td><b>gunzip</b></td> <td>Uncompress a file using <b>gunzip</b>. Options
include:

<ul>

<li><b>-f</b> forces decompression even if the file has multiple links or the
corresponding file already exists.

</li>

<li><b>-r</b> decompress all files in a directory tree.

</li>

</ul></td> <td><b> gunzip file.tar.gz </b>uncompresses the tar archive. <b>  
gunzip file.cpio </b>uncompresses the cpio file. </td>

</tr>

<tr> <td><b>bzip2</b></td> <td>Compress/decompress a file using <b>bzip2</b>.

<ul>

<li><b>-d</b> decompresses the file.

</li>

<li><b>-k</b> keeps the original file unchanged.

</li>

</ul>

<b>Note</b>: This is the same as <b>tar -j </b> command.

</td> <td><b>bzip2 file.tar</b> creates a compressed file and removes the
original file.  
<b>bzip2 -k file.tar </b>creates a tar archive<b> </b>leaving the original
file unchanged.<b>  
gzip -d </b> <b>file.tar.gz </b>uncompresses the tar archive. </td>

</tr> </table>

