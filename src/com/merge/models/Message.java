package com.merge.models;

import java.util.Date;
import com.merge.models.Contact;

public class Message {
    private final String hashId;
    private final Date sent;
    private final Contact receiver;
    private final Profile sender;
}
