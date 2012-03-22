// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.4.1

package Ice;

// <auto-generated>
//
// Generated from file `LocalException.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


/**
 * A datagram exceeds the configured size.
 * 
 * This exception is raised if a datagram exceeds the configured send or receive buffer
 * size, or exceeds the maximum payload size of a UDP packet (65507 bytes).
 * 
 **/
public class DatagramLimitException extends ProtocolException
{
    public DatagramLimitException()
    {
        super();
    }

    public DatagramLimitException(String reason)
    {
        super(reason);
    }

    public String
    ice_name()
    {
        return "Ice::DatagramLimitException";
    }
}