One-to-Many / Many-to-One


* User
    * One-to-Many with Report
    * One-to-Many with Event
    * One-to-Many with EventReview
    * One-to-Many with OnedayClass
    * One-to-Many with OnedayReview
    * One-to-Many with Posting
    * One-to-Many with PostingComment
    * One-to-Many with PostingLike
    * One-to-Many with PostPersonTag
    * One-to-Many with UserloginLog
    * One-to-Many with UserEventBmark
    * One-to-Many with UserFollow (follower)
    * One-to-Many with UserFollow (followee)
    * One-to-Many with UserImg
    * One-to-Many with UserInquire
    * One-to-Many with UserInterest
    * One-to-Many with UserOnedayBmark
    * One-to-Many with UserCart
    * One-to-Many with UserCoupon
    * One-to-Many with UserPoint응 고망ㅇㄴ란
    * One-to-Many with UserPurchaseList
    * One-to-One with UserSetting
    * One-to-One with UserProfile
    * One-to-One with UserStat
* Event
    * Many-to-One with User
    * One-to-Many with EventCast
    * One-to-Many with EventDetailImage
    * One-to-Many with EventImage
    * One-to-Many with EventReview
    * One-to-Many with UserEventBmark
* OnedayClass
    * Many-to-One with User
    * Many-to-One with Category
    * One-to-Many with OnedayDate
    * One-to-Many with OnedayDetailImage
    * One-to-Many with OnedayImage
    * One-to-Many with OnedayReview
    * One-to-Many with UserOnedayBmark
* Posting
    * Many-to-One with User
    * One-to-Many with PostHashtag
    * One-to-Many with PostingComment
    * One-to-Many with PostingImage
    * One-to-Many with PostingLike
    * One-to-Many with PostPersonTag
    * One-to-Many with PostTagLink
* Agency
    * One-to-Many with Actor
* Actor
    * Many-to-One with Agency
    * One-to-Many with ActorsImage
* EventDate
    * One-to-Many with EventOption
* OnedayDate
    * Many-to-One with OnedayClass
    * One-to-Many with OnedayOption
* OnedayReview
    * Many-to-One with User
    * Many-to-One with OnedayClass
    * One-to-Many with OnedayReviewImage
* Hashtag
    * One-to-Many with PostHashtag
* Category
    * One-to-Many with OnedayClass
    * One-to-Many with UserInterest
* UserInquire
    * Many-to-One with User
    * Many-to-One with UserPurchaseList
    * One-to-Many with UserInquireReply

Many-to-Many (through join tables)

* User and Event through UserEventBmark
* User and OnedayClass through UserOnedayBmark
* User and Posting through PostingLike
* User and User through UserFollow
* User and Category through UserInterest
* Posting and Hashtag through PostHashtag
* Posting and User through PostPersonTag