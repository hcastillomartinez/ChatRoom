# TupleSpace/ChatRoom
### Students: Hector Castillo Martinez
### Introduction
Using TupleSpace to build chatRoom where each chatRoom user has a name, the user has ability to see active/all users, last 10
messages received from any users on list are shown in chronological order, and each user has ability to generate new message,
which can be seen by any user. 
### Usage
No users exist when program is run initially and should be added in by person using program. No two users can have the
same name and when added will change list shown to be list showing all users. When users are added they are set to not
taken their turn yet and are not active(online). Each user can only do one thing once they are selected either set 
online/offline or send a message. When user has taken action they will not be allowed to do anything else until another
user listed is selected. User can take one or no action when selected. Last 10 messages are always displayed with oldest message being replaced
by the new message sent. Users are set online by clicking top bar where name is displayed and turns green when set online
and blue if set offline, initially are users have blue bar as they are set to offline. Active button will show active
users and all button will show all users. 
### Project Assumptions
It made sense to make the messages from users the tuples (pattern: timeStamp,User,message) and storing all messages, regardless
of User, in same TupleSpace. When user takes turn I made it so person using program must select another user manually.
### Versions
In top level of directory.
#### V1
Does what is specified in usage. 
### Docs
In doc folder you will find both diagrams and description of testing.
### Status
#### Implemented Features
Can add any amount of users, each user can be set online or offline, user has ability to ask to see
all users or only the active users, only last 10 messages will be displayed. User can add new messages and only take one 
action per turn.
#### Known Issues 
Person using program needs to add at least 2 people initially so that turns could be taken place, otherwise single user 
would be stuck until new user is added and then selected.
