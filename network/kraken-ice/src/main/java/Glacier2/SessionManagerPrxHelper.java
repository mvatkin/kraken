// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.4.1

package Glacier2;

// <auto-generated>
//
// Generated from file `Session.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


/**
 * The session manager for username/password authenticated users that
 * is responsible for managing {@link Session} objects. New session objects
 * are created by the {@link Router} object calling on an application-provided
 * session manager. If no session manager is provided by the application,
 * no client-visible sessions are passed to the client.
 * 
 * @see Router
 * @see Session
 * 
 **/
public final class SessionManagerPrxHelper extends Ice.ObjectPrxHelperBase implements SessionManagerPrx
{
    /**
     * Create a new session.
     * 
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     * @return A proxy to the newly created session.
     * 
     * @throws CannotCreateSessionException Raised if the session
     * cannot be created.
     * 
     **/
    public SessionPrx
    create(String userId, SessionControlPrx control)
        throws CannotCreateSessionException
    {
        return create(userId, control, null, false);
    }

    /**
     * Create a new session.
     * 
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy to the newly created session.
     * 
     * @throws CannotCreateSessionException Raised if the session
     * cannot be created.
     * 
     **/
    public SessionPrx
    create(String userId, SessionControlPrx control, java.util.Map<String, String> __ctx)
        throws CannotCreateSessionException
    {
        return create(userId, control, __ctx, true);
    }

    private SessionPrx
    create(String userId, SessionControlPrx control, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws CannotCreateSessionException
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("create");
                __delBase = __getDelegate(false);
                _SessionManagerDel __del = (_SessionManagerDel)__delBase;
                return __del.create(userId, control, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __create_name = "create";

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     **/
    public Ice.AsyncResult begin_create(String userId, SessionControlPrx control)
    {
        return begin_create(userId, control, null, false, null);
    }

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_create(String userId, SessionControlPrx control, java.util.Map<String, String> __ctx)
    {
        return begin_create(userId, control, __ctx, true, null);
    }

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     **/
    public Ice.AsyncResult begin_create(String userId, SessionControlPrx control, Ice.Callback __cb)
    {
        return begin_create(userId, control, null, false, __cb);
    }

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_create(String userId, SessionControlPrx control, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_create(userId, control, __ctx, true, __cb);
    }

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     **/
    public Ice.AsyncResult begin_create(String userId, SessionControlPrx control, Callback_SessionManager_create __cb)
    {
        return begin_create(userId, control, null, false, __cb);
    }

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_create(String userId, SessionControlPrx control, java.util.Map<String, String> __ctx, Callback_SessionManager_create __cb)
    {
        return begin_create(userId, control, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_create(String userId, SessionControlPrx control, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__create_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __create_name, __cb);
        try
        {
            __result.__prepare(__create_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            __os.writeString(userId);
            SessionControlPrxHelper.__write(__os, control);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    /**
     * ice_response indicates that
     * the operation completed successfully.
     * @param __ret (return value) A proxy to the newly created session.
     * 
     **/
    public SessionPrx end_create(Ice.AsyncResult __result)
        throws CannotCreateSessionException
    {
        Ice.AsyncResult.__check(__result, this, __create_name);
        if(!__result.__wait())
        {
            try
            {
                __result.__throwUserException();
            }
            catch(CannotCreateSessionException __ex)
            {
                throw __ex;
            }
            catch(Ice.UserException __ex)
            {
                throw new Ice.UnknownUserException(__ex.ice_name());
            }
        }
        SessionPrx __ret;
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __ret = SessionPrxHelper.__read(__is);
        __is.endReadEncaps();
        return __ret;
    }

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     **/
    public boolean
    create_async(AMI_SessionManager_create __cb, String userId, SessionControlPrx control)
    {
        Ice.AsyncResult __r;
        try
        {
            __checkTwowayOnly(__create_name);
            __r = begin_create(userId, control, null, false, __cb);
        }
        catch(Ice.TwowayOnlyException ex)
        {
            __r = new IceInternal.OutgoingAsync(this, __create_name, __cb);
            __r.__exceptionAsync(ex);
        }
        return __r.sentSynchronously();
    }

    /**
     * Create a new session.
     * 
     * @param __cb The callback object for the operation.
     * @param userId The user id for the session.
     * 
     * @param control A proxy to the session control object.
     * 
     * @param __ctx The Context map to send with the invocation.
     **/
    public boolean
    create_async(AMI_SessionManager_create __cb, String userId, SessionControlPrx control, java.util.Map<String, String> __ctx)
    {
        Ice.AsyncResult __r;
        try
        {
            __checkTwowayOnly(__create_name);
            __r = begin_create(userId, control, __ctx, true, __cb);
        }
        catch(Ice.TwowayOnlyException ex)
        {
            __r = new IceInternal.OutgoingAsync(this, __create_name, __cb);
            __r.__exceptionAsync(ex);
        }
        return __r.sentSynchronously();
    }

    public static SessionManagerPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        SessionManagerPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (SessionManagerPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::Glacier2::SessionManager"))
                {
                    SessionManagerPrxHelper __h = new SessionManagerPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static SessionManagerPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        SessionManagerPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (SessionManagerPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::Glacier2::SessionManager", __ctx))
                {
                    SessionManagerPrxHelper __h = new SessionManagerPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static SessionManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        SessionManagerPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::Glacier2::SessionManager"))
                {
                    SessionManagerPrxHelper __h = new SessionManagerPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static SessionManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        SessionManagerPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::Glacier2::SessionManager", __ctx))
                {
                    SessionManagerPrxHelper __h = new SessionManagerPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static SessionManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        SessionManagerPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (SessionManagerPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                SessionManagerPrxHelper __h = new SessionManagerPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static SessionManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        SessionManagerPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            SessionManagerPrxHelper __h = new SessionManagerPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _SessionManagerDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _SessionManagerDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, SessionManagerPrx v)
    {
        __os.writeProxy(v);
    }

    public static SessionManagerPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            SessionManagerPrxHelper result = new SessionManagerPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
