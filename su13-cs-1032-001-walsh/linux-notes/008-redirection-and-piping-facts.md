---
layout: page
title:  Redirection And Piping Facts
---

####

Administrators often use the following methods to create, send, or gather
information on a Linux system:

<table>

<tr> <td>Method</td> <td>Description</td>

</tr>

<tr> <td>Redirection</td> <td><i>Redirection</i> directs standard input,
output, and error streams from and to locations other than the default. Be
aware of the following redirection details:

<ul>

<li>By default, the Linux system classifies information with the following
file descriptors:

<ul>

<li>Standard input (stdin) comes from the keyboard. In redirection, 0
represents stdin.

</li>

<li>Standard output (stdout) displays on the monitor. In redirection, 1
represents stdout.

</li>

<li>Standard errors (stderr) display on the monitor. In redirection, 2
represents stderr.

</li>

</ul>

</li>

<li>Linux commands use the greater-than symbol (<b>></b>) to show redirection
of output, the less-than symbol arrow (<b><</b>) to indicate redirection of
input, and the double greater-than symbol (<b>>></b>) to append the output to
another file or command.

</li>

<li>The <b>tee</b> command reads from standard input and writes to standard
output <i>and</i> files.

</li>

</ul> </td>

</tr>

<tr> <td>Piping</td> <td><i>Piping</i> directs the output of one command into
the input of another command. Pipes:

<ul>

<li>Use the pipe symbol (<b>|</b>).

</li>

<li>Can combine several commands to make a stream.

</li>

</ul> </td>

</tr> </table>

The following table shows the results of several redirection and piping
commands:

<table>

<tr> <td>Example</td> <td>Result</td>

</tr>

<tr> <td><b>ls /usr > /tmp/deleteme</b></td> <td><b>ls /usr >
/tmp/deleteme</b> places the list of files in the <b>/usr</b> directory into a
file named <b>/tmp/deleteme</b>.</td>

</tr>

<tr> <td><b>ls /nonesuch > /tmp/deleteme</b></td> <td><b>ls /nonesuch >
/tmp/deleteme</b> does not write anything to a file and sends an error message
to the monitor '/nonesuch not found'.</td>

</tr>

<tr> <td><b>ls /nonesuch 2 > /tmp/deleteme</b></td> <td><b>ls /nonesuch 2 >
/tmp/deleteme</b> writes the standard error message to a file named
<b>/tmp/deleteme</b>.</td>

</tr>

<tr> <td><b>ls /bin /nonesuch > /tmp/deleteme</b></td> <td> <b>ls /bin
/nonesuch > /tmp/deleteme</b> writes the contents of the <b>/bin</b> directory
to the <b>/tmp/deleteme</b> file, but sends the error message '/nonesuch not
found' to the screen.</td>

</tr>

<tr> <td><b>ls /bin /nonesuch > /tmp/deleteme 2>&1</b></td> <td><b>ls /bin
/nonesuch > /tmp/deleteme 2>&1</b> directs the standard output to the
<b>/tmp/deleteme</b> file, then directs that the standard error messages be
sent to the same place as the standard output. Both the list of files in the
<b>/bin</b> directory and the error message are written to the file.</td>

</tr>

<tr> <td><b>ls /bin /nonesuch 2>&1 > /tmp/deleteme</b></td> <td><b>ls /bin
/nonesuch 2>&1 > /tmp/deleteme</b> writes the contents of the /bin directory
to the <b>/tmp/deleteme</b> file, but sends the error message '/nonesuch not
found' to the screen. This is because standard error messages are directed to
the same place that standard output goes, but this is before standard output
has been directed to the file.</td>

</tr>

<tr> <td><b>ls /bin >> /tmp/deleteme</b></td> <td><b>ls /bin >>
/tmp/deleteme</b> appends the list of files from the <b>/usr</b> directory on
to the end of the <b>/tmp/deleteme</b> file.</td>

</tr>

<tr> <td><b>sort < unordered_file.txt > ordered_file.txt</b></td> <td> <b>sort
< unordered_file.txt > ordered_file.txt</b> takes input from the
unordered_file.txt file sends it to the sort command, and then writes a new
file named <b>ordered_file.txt</b>.</td>

</tr>

<tr> <td><b>cat /usr/wordlist1 /usr/wordlist2 | sort</b></td> <td>Sends the
output of the cat command, the contents of wordlist1 and wordlist2, to the
input of the sort command. The result is a sorted list of the combined
contents of <b>wordlist1</b> and <b>wordlist2</b>.</td>

</tr>

<tr> <td><b>cat /usr/wordlist1 /usr/wordlist2 | mail jdoe</b></td> <td>Mails
the combined list of words in <b>wordlist1</b> and <b>wordlist2</b> to the
user jdoe.</td>

</tr>

<tr> <td><b>ls /bin | sort | mail jdoe</b></td> <td>Lists the contents of /bin
then sorts the combined contents and mails them to jdoe.</td>

</tr>

<tr> <td><b>cat /usr/wordlist1 /usr/wordlist2 | sort | tee
sortedwordlist</b></td> <td>Lists the contents of <b>wordlist1</b> and
<b>wordlist2</b> then sorts the combined contents, then sends the results to
the monitor and a file named <b>sortedwordlist</b>.</td>

</tr>

<tr> <td><b>cat /usr/wordlist1 | tee log.txt</b></td> <td>Writes to the
standard output and the log.txt file.</td>

</tr> </table>

