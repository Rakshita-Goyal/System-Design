//Proxy provides a substitute object that controls access to the real object.
// Instead of client talking directly to RealVideoService,
// it talks to VideoServiceProxy.
// why
// Control access (security)
// ✔ Lazy loading (create object only when needed)
// ✔ Logging
// ✔ Caching
// ✔ Remote access

// Remote Proxy
// 👉 Used when the real object is in a different location (remote server / network).
// Purpose:
// Handle network communication for you.

// Virtual Proxy
// 👉 Used for lazy loading / heavy objects.
// Purpose:
// Create object only when needed (save memory & time).
//proxy takes the refernce of real object but create a object only when the client ask for the method 

// Protection Proxy
// 👉 Used for access control / security.
// Purpose:
// Check permissions before allowing access.


