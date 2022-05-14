package hld.dropbox;

public class Dropbox {
    //23+3+2+4
    public static void main(String[] args) {
        System.out.println(4/5);
        System.out.println(14%5);
    }
}

/*
Functional :
1. Store files and retrieve (images, videos, pdf, text, zip etc etc)
2. Keep track of multiple versions (last 5 versions)
3. Share files and photos to other users.
4. Offline editing is supported. when user comes back online the remote servers are synced to it.
5. files should be synchronized among all the devices.
6. Support large files upto GB of data.

Non functional :
1. Highly available, reliable, scalable at cost, consistent.
2. Latency is fine.
3. Atomicity is must.

extended:
on the fly update

=====
Design considerations:
1. heavy read and write
2. Read to write ratio is almost same.
3. Internally files is broken into small chunks and stored. So that failed operation can resume from the part it
failed.
4. Client smart enough to sync on the diff among the files.

=====

Capacity estimations:
1. 500 M total users and 100 M daily active users.
2. Each user connects with 3 different devices.
3. on an average each user has 200 files stored in cloud. So total 200 * 500M = 100000M = 100 B files stored.
4. assume average file size is 100KB.
so total data req = 100 KB * 100 B = 10000 B KB = 10 PetaKB = 10 Petabytes of storage.
=====

Component design:
1.

 */