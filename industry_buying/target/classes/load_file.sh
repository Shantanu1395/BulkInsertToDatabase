#!/bin/bash
# USAGE:  sh load_file.sh "FILE_TO_LOAD" LINES_IN_EACH_FILE_SPLIT "DATABASE_NAME" "TABLE_NAME" "COLUMN_SEPARATOR"
# Eg:     sh load_file.sh "/path/to/filename.csv" 1000000 "fileload" "sample_schema.cunique" ","

FILE_TO_LOAD=$1
LINES_IN_EACH_FILE_SPLIT=$2		#pass 0 to skip splitting.
DATABASE_NAME=$3
TABLE_NAME=$4
COLUMN_SEPARATOR=$5

DB_SERVER='localhost'
DB_USERNAME='ccpa_login_2'
DB_PASSWORD='Hasher@123'
BCP_ERR_LOGS_FILE='/c/opt/ds_fileprocessor/logs/bcplogs.txt'
FEEDS_SPLIT_TO='/c/opt/ds_fileprocessor/feeds/feed_splits'
FEEDS_BACKUP_TO='/c/opt/ds_fileprocessor/feeds/feed_backups'

exit_if_failed() {
    result=$?
    if [ "$result" != 0 ]; then
        printf "!!!Previous command failed with exit code:${result}!!!\n"
        exit 42
    fi
}


echo "Starting load at $(date)"

echo "Input data:"
echo "FILE_TO_LOAD = $FILE_TO_LOAD"
echo "LINES_IN_EACH_FILE_SPLIT = $LINES_IN_EACH_FILE_SPLIT"
echo "DATABASE_NAME = $DATABASE_NAME"
echo "TABLE_NAME = $TABLE_NAME"
echo "COLUMN_SEPARATOR = $COLUMN_SEPARATOR"
echo
echo

filename_part=$(basename -- "$FILE_TO_LOAD")
extension_part="${filename_part##*.}"
filename_part="${filename_part%.*}"

#Should be part of 1st time job
echo "Creating the table:$TABLE_NAME"
sqlcmd -b -d $DATABASE_NAME -Q "DROP TABLE IF EXISTS cunique" -U $DB_USERNAME -P ''$DB_PASSWORD'' -S $DB_SERVER
exit_if_failed
sqlcmd -b -d $DATABASE_NAME -Q "CREATE TABLE cunique(id int, Message varchar(255), truth varchar(255),cube varchar(255),google varchar(255),google_spam varchar(255),google_not_spam varchar(255),ibm varchar(255),ibm_spam varchar(255),ibm_not_spam varchar(255))" -U $DB_USERNAME -P ''$DB_PASSWORD'' -S $DB_SERVER
exit_if_failed

#echo "Clearing the table:$TABLE_NAME"
#sqlcmd -b -d $DATABASE_NAME -Q "DELETE FROM $TABLE_NAME" -U $DB_USERNAME -P ''$DB_PASSWORD'' -S $DB_SERVER
#exit_if_failed
#
#if [ $CHECKSUM_ENABLED == 'TRUE' ]; then
#	echo "Drop checksum column in table:$TABLE_NAME"
#	sqlcmd -b -d $DATABASE_NAME -Q "ALTER TABLE $TABLE_NAME DROP COLUMN [checksum]" -U $DB_USERNAME -P ''$DB_PASSWORD'' -S $DB_SERVER
#	exit_if_failed
#fi
#
#if [ $LINES_IN_EACH_FILE_SPLIT == '0' ]; then
#	echo "Skipping the file split. Will be using the file as is."
#	echo "File being processed: $FILE_TO_LOAD"
#	bcp $DATABASE_NAME.$TABLE_NAME in $FILE_TO_LOAD -c -t "$COLUMN_SEPARATOR" -r'0x0A' -F '2' -U $DB_USERNAME -P ''$DB_PASSWORD'' -b 10000 -S $DB_SERVER -e $BCP_ERR_LOGS_FILE
#	exit_if_failed
#else
#	#Splitting files based on no of lines and input files.
#	feeds_split_dir="$FEEDS_SPLIT_TO/${filename_part}_splits"
#	echo "Creating feeds split directory: ${feeds_split_dir}"
#	mkdir -p "$feeds_split_dir"
#	exit_if_failed
#	echo "Cleaning up split folder: $feeds_split_dir/*"
#	rm -rf $feeds_split_dir/*
#
#	echo "Starting spliting file to $feeds_split_dir"
#	split -l $LINES_IN_EACH_FILE_SPLIT $FILE_TO_LOAD "$feeds_split_dir/${filename_part}_split_" --additional-suffix=".$extension_part"
#	exit_if_failed
#	number_of_splits="$(find ${feeds_split_dir} -type f | wc -l)"
#	echo "Splitted into $number_of_splits files of $LINES_IN_EACH_FILE_SPLIT rows each"
#
#	#Iterating over each file in the split folder and batch processing the file to sql server
#	for split_file in "${feeds_split_dir}"/*
#	do
#	  echo
#	  echo
#	  echo "File being processed: $split_file"
#	  bcp $DATABASE_NAME.$TABLE_NAME in $split_file -c -t "$COLUMN_SEPARATOR" -r'0x0A' -F '1' -U $DB_USERNAME -P ''$DB_PASSWORD'' -b 10000 -S $DB_SERVER -e $BCP_ERR_LOGS_FILE
#	  #Treat warnings as error and continue with the next file
#	  exit_if_failed
#	done
#
#	echo "Removing splitted files from $feeds_split_dir"
#	rm -rf $feeds_split_dir/*
#fi
#
#if [ $CHECKSUM_ENABLED == 'TRUE' ]; then
#	echo "Adding checksum column in table:$TABLE_NAME"
#	sqlcmd -b -d $DATABASE_NAME -Q "ALTER TABLE $TABLE_NAME ADD [checksum] INT" -U $DB_USERNAME -P ''$DB_PASSWORD'' -S $DB_SERVER
#	exit_if_failed
#fi
#
#echo "Moving file to backup directory($FEEDS_BACKUP_TO)"
#mv $FILE_TO_LOAD $FEEDS_BACKUP_TO/
#
#echo "Import successful";
#echo
#echo "Load ended at $(date)";
#echo
#echo
