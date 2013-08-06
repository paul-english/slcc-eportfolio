---
layout: page
title:  Sql Facts
---

Structured Query Language (SQL) is used in most database applications. It
provides commands for working with databases and tables, for populating tables
with data, and for querying and organizing the data. This lesson uses a MySQL
database for demonstration purposes.

The following table lists commands used to access and control a MySQL server:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>mysql_install_db</b></td> <td>Install the system tables and other
database items for MySQL.</td> <td> </td>

</tr>

<tr> <td><b>mysqlshow</b></td> <td>See a list of databases in MySQL.</td> <td>
</td>

</tr>

<tr> <td><b>mysqladmin</b></td> <td>Manage a MySQL database. Options include:

<ul>

<li><b>password</b> creates a password.

</li>

<li><b>-u</b> specifies a user.

</li>

<li><b>-h</b> specifies the host for the MySQL server.

</li>

</ul> </td> <td><b>mysqladmin -u user -h localhost password '123456'</b>
creates the user account on the local host with a password of 123456.  
<b>Note:</b> if the <b>-h</b> option is omitted, the local host is implied.
</td>

</tr>

<tr> <td><b>mysql</b></td> <td>Access the MySQL command line. Options include:

<ul>

<li><b>-u </b>specifies a user

</li>

<li><b>-p </b>specifies a password. If used alone,<b> -p</b> prompts for the
password in the next line.

</li>

</ul> </td> <td><b>mysql</b> <b>-u root -p </b>accesses MySQL after prompting
for a password.  
<b>mysql -u root -p123456</b> Accesses MySQL using the password for root. This
command is considered insecure.  
<b>mysql -u root -p 123456</b> accesses MySQL after prompting for a password,
and attempts to connect to a database named <i>123456</i>.</td>

</tr>

<tr> <td><b>service mysqld start rcmysql start </b></td> <td>Start the mysqld
daemon for MySQL. </td> <td><b>service mysqld start </b>starts the MySQL
daemon on a System V system.</td>

</tr> </table>

The following list defines several basic database objects:

  * A _database_ is a group of related data organized using tables and accessed using a database application. 
  * A _table_ is a set of data organized into records (rows), and attributes (columns).
  * A _record_ is an item or entity in a table with its attributes listed across a row. For example, a record may have a name of 'aspen tree', a height of '3 meters', and a type of 'deciduous'. Records are sometimes called tuples.
  * _Attributes_ in a table are organized into columns. For example a name attribute might have 'aspen tree' in the first record, 'oak tree' in the second record, and 'white fir' in the third record.
  * _Integers_ are whole numbers between -2,147,483,648 and 2,147,483,647.
  * A _primary key_ is an attribute of a record that uniquely identifies it from all other records in the table. For example, a telephone number or a unique ID number can be used as a primary key. Primary keys are used to specify records when querying data from multiple tables.

When adding information to a database, certain attributes have specific data
types. For example, a field that holds a price in US dollars uses numbers with
two decimal points for dollars and cents, and a name uses characters. SQL has
several data types available when adding information to tables. The following
list describes several common SQL data types.

  * _Character_ data types allow basic alpha-numeric characters. These use an exact length.
  * _Varchar_ data types allow alpha-numeric characters of any length up to a maximum specified length.
  * _Decimal_ data types hold numbers that can have decimal values up to 38 decimal places. The exact number of decimal places is specified.
  * _Float_ is a numeric data type that allows floating decimals. This stores approximate values.
  * _Time_ holds hours, minutes, seconds, and fractions of seconds.
  * _Date_ holds calendar dates.
  * _Enum_ holds a set of specified values such as 'small', 'medium', and 'large'.

Administrators use several commands to create, modify, and extract data from
databases. The following table lists several of the most commonly-used
commands.

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>CREATE DATABASE</b></td> <td>Create a new database. </td>
<td><b>CREATE DATABASE clothing; </b>creates a database named clothing. </td>

</tr>

<tr> <td><b>USE</b></td> <td>Specify the database to work in. </td> <td><b>USE
clothing;</b> accesses the clothing database. </td>

</tr>

<tr> <td><b>SHOW TABLES</b></td> <td>Displays a list of tables in a
database.</td> <td><b>SHOW TABLES clothing;</b> lists the tables in the
clothing database.</td>

</tr>

<tr> <td><b>CREATE TABLE</b></td> <td>Add a table to the database and create
the attributes for records to be added to the table. </td> <td><b>CREATE TABLE
shirts (invoice CHARACTER(7), type VARCHAR(40), color VARCHAR(20), price
DECIMAL(5,2), size ENUM('XS','S','M','L','XL','XXL','XXXL'),
location(VARCHAR(50), gender ENUM('male','female','either')); </b>creates a
table called shirts; adds attributes for invoice, type, color, price, size,
location, and gender; and defines the data types for each attribute.</td>

</tr>

<tr> <td><b>INSERT INTO</b></td> <td>Add records to the table. A value must be
specified for each attribute in the table. To leave an attribute blank, place
two commas together. </td> <td><b>INSERT INTO shirts VALUES
0008103,'t-shirt','green',7.95,'S','warehouse1 13-C-3','etiher';</b> adds a
record for small green t-shirts.  
<b>INSERT INTO shirts VALUES 0008094,'dress
shirt','white',14.49,'L','warehouse1 5-J-1','male';</b> adds a record for
men's large white dress shirts.</td>

</tr>

<tr> <td><b>DESCRIBE</b></td> <td>See a description of a database object.</td>
<td><b>DESCRIBE shirts;</b> displays information about the <i>shirts</i>
table. </td>

</tr>

<tr> <td><b>SELECT</b></td> <td>Retrieve information from a table. Clauses
include:

<ul>

<li><b>WHERE</b> filters using data from a specified field.

</li>

<li><b>SORT BY</b> sorts displayed data based on an attribute name.

</li>

<li><b>GROUP BY</b> determines how information in a list is grouped.

</li>

</ul> </td> <td><b>SELECT (location,price) FROM shirt WHERE color='green' AND
type='t-shirt' AND size='M' SORT BY price;</b> shows the location and price of
all medium green t-shirts from the shirt table. The results are sorted by
price.</td>

</tr>

<tr> <td><b>UPDATE</b></td> <td>Change the values in a record. </td>
<td><b>UPDATE shirts SET price=11.95 WHERE type='dress shirt' AND size='L' AND
gender='male';</b> changes the price on large men's dress shirts.</td>

</tr>

<tr> <td><b>DELETE FROM</b></td> <td>Remove records from a table. </td>
<td><b>DELETE FROM shirts WHERE color='pink' AND type='polo' AND
gender='male';</b> deletes records for men's pink polo shirts. </td>

</tr>

<tr> <td><b>ALTER TABLE</b></td> <td>Add, change or remove attributes from
tables. </td> <td><b>ALTER TABLE shirts ADD COLUMN sleeve
ENUM('short','long');</b> creates a new attribute for sleeve length.  
<b>ALTER TABLE shirts ALTER COLUMN type style;</b> changes the name of the
type attribute to style.  
<b>ALTER TABLE shirts DROP COLUMN location;</b> deletes the location
attribute. </td>

</tr>

<tr> <td><b>DROP TABLE</b></td> <td>Delete an existing table. </td>
<td><b>DROP TABLE shirts;</b> deletes the shirts table.</td>

</tr> </table>

Keep the following in mind when working with SQL statements:

  * Statements must end with semicolons. If a semicolon is omitted, the command terminal assumes that the command will be finished on the next line.
  * In commands, character values need single quotes, but if number values have single quotes, they are treated like character strings. This makes a difference in sorting and doing actions such as getting the sum of a column. If an attribute only holds numbers, use a data type designed to hold numbers.

