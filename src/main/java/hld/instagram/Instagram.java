package hld.instagram;

public class Instagram {
}

/*
Requirement analysis :

Functional :
1. User able to upload/download/view photo.
2. user should be able to follow other users.
3. System should generate news feeds for a particular user by displaying top photos of followed users.
4. search photo, video title based search.

Non functional req:
1. Service should be highly available.
2. We can give up on consistency. Or eventual consistent system.
3. Latency of 200ms for news feed generation.
4. System should be highly reliable (any uploaded photo/video should not be lost).

Some design considerations:
1. System is heavy read.
2. Practically users can upload as many photos they want so storage should be managed efficiently.
3. data should be 100% reliable.

Capacity estimations:
Lets assume that there are 500M users and 1M daily active users.
Lets assume 2M photos added each day.
Average photo size = 200KB.
Total space per day = 2M * 200KB = 400GB.
Total space for 10 years = 400 GB * (3650) =1460000 GB = 1460 TB for 10 years

Metadata store data-size for 10 years:
User table :
Each int and datetime is 4 byte. so each row is 68 bytes
For 500 M = 500M * 68 = 34000 M = 35 GB

Photo table:
Total 1 row = 284 bytes.
Total = 2M * 3650 * 284 bytes =2073200 M bytes = 2 TB data.

User_follow:
500 million users * 500 followers * 8 bytes ~= 1.82TB

Total = 1.82TB +  2 TB + 35 GB = 3.7 TB

======
Database design:
User(user_id, email, DoB, creation_date, last_login)
Photo(photo_id, user_id, photo_path, creation_date)
user_follow(followee_id fk, follower_id fk)

We can store the metadata in sql, but its not scalable. Also, here high consistency is not required.
We can store in nosql key-value data store with key as photo_id and value as remaining content.
Key-value datastore in inherently scalable and there are replicas to maintain reliability.
Also, these data stores have lazy deletion, so undeleting operation can be performed.

========
Component design:

Write is a heavy operation as we are uploading photos. So, this can hog the server if lets say 500 users are uploading the photos.
So, we can split write and read into dedicated services. So that application server are not hogged by write requests and read requests
 are being starved.

======
Redundancy and reliability:

Redundancy removes single point of failure.
A secondary services can keep running behind the scene, so that whenever a primary is down then the it can
failover on the secondary parallely running service.

==========
Data sharding:

Lets say each DB server can store max of 1TB. Let us keep 10DB servers.
1. user_id% 10
store each photo of a particular user in one shard. But problem is that uneven distribution.
also photo_id can be appended with shard_id so that its unique across several shards.

2. Generate based on unique photo_id.
photo_id%10
For generating photo_id KGS can be used.

To scale this particular service in future:
We can have multiple physical DB servers in a single shard initially and then keep on adding up other physical shards
whenever required and move one DB server to new physical shard.

========
Ranking and news feed generation:

Assume that we have to show only 100 photos in news feed.
1. Find all users which this user follow.
2. Take recent 5 day photos of all these users.
3. Pass these to ranking algorith. which will rank based on likeness, recency etc
4. It is heavy operation as it involves merging ,ranking , sorting etc.

Pre-generating the News Feed and storing them in a separate table with latest_generation_date.
12. News Feed Creation with Sharded Data
=> we can use timestamp in photo_id itself so that as there is primary index we can query data quickly.

Lets say we want to store for 50 years:
so (50 * 365 *24 * 3600)=1576800000 = 1.5 Billion keys ==> 31 bits
Also, there 2M photos every day = 2000000/86400 = 24 photos per sec

So total 40 bits => 5 bytes of storage required to store one photo_id

 */