package hld;

public class PasteBin {
}

/*
1. Requirements:
    => Functional :
        1. Given text, store on DB and generate URL.
        2. Given URL, retrieve text.
        3. upload text only.
        4. Data purged after certain interval of time.
        5. Custom alias for their paste.

    => Non Functional :
        1. System should be highly reliable. Pastes should not be lost.
        2. Low latency
        2. System highly available.
        3. paste link should not be guessable.

    => Extended requirements:
        1. Analytics : how many times a paste was accesses, from which location its accessed most of the times.
        2. To share a group of persons. Private share kind of.
        3. Our service should be accessible via REST api by other services.

=========
2. Capacity estimations :
=> A paste can be of maximum 10MB.
=> The custom URL should be of fixed length.

System is heavy read, there will be 5:1 read to paste creation ratio.

-> Traffic estimation:
Lets assume that 1 Million pasts are added every day. So, reads will be 5M/day.

Write per sec = 1000000/ (24*3600) = 12 pastes/sec
Read per sec = 60 reads /sec

-> Storage estimation:
Lets say we keep data for 1 year max. And at max they can upload 10MB. But on an average lets assume its 10KB.

So, total pasts stored per year = 10KB * 1M * 365 = 3.6 TB per year. = 36TB for 10 years if we store it for 10 years.
Total pasts stored for 10 years = 1 M * 10 * 365 = 3.65 Billion.

Also, we will use base64 ( 0-9, a-z and A-Z) encoding to store the url of 6 characters:
So total unique url : 64^6 = 68 Billion unique strings of 6 characters.

Now to space required to store 3.6 billion unique string = 3.6B * 6 bytes = 22GB

-> Bandwidth:
For write : 12 pasts /sec = 12 * 10KB/sec = 120KB/sec
For read : 60 reads /sec = 0.6 MB/sec

-> Memory estimate:
Applying 20-80% rule. We will cache 20% of the urls.
5 M * 10 KB * 20%  = 50 GB  * 20%  = 10GB of memeory is required per day for caching.

=======
3. System API:
We can expose REST API:

Url addPaste(api_dev_key, user_name, custom_url, expiry_time, paste_Date)
getPaste(api_dev_key, api_paste_key)

deletePaste(api_dev_key, api_paste_key)

============

4.Database design:
-> Each paste object size is medium around 10MB.
-> There are many records to store.
-> service is read heavy.
-> The metadata stored is also small < 10Kb.

user(user_id number primary key, name varchar, email varchar, creation_date datetime, last_login datetime)
paste(hash_key varchar, content_key varchar, user_id FK, creation_date datetime, expiry_date)

==========

High level design:
-> Since the original paste can be of 10MB we can store that in an object storage(like Amazon S3)
-> And store the metadata separately the the DB.
==========

Component design:
1. Client , app server, Object storage and Metadata storage, KGS (KGS replicas)
Metadata database : use mySQl, Cassandra, dynamo etc.
Object storage : Amazon s3. we can horizontally scale it whenever required.
Refer the diagram.

Rest things same as url shortning.
==========
 */