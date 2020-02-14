# Exercise : Hashicorp

by *James Nyika*


### A few Anticipated questions

1. Can you outline the 7 layer OSI model ?

  ![OSI](../resources/images/osi-model.gif)

2. What does 'x' layer do ?

   See the top qn

3. What is a proxy ?
 Proxies are remote computers used to restrict Internet access, filter content, and make Internet browsing more secure.

4. Types of Proxies

 * HTTP Proxies – These only cater to web pages. If you set up your browser with an HTTP proxy, all your browser traffic will be rerouted through it. They are useful for web browsing and accessing geo-restricted websites.

 * SOCKS Proxies – These proxies are not limited to web traffic but still only work on the application level. For example, you can set it up on a game, video streaming app, or a P2P platform. Although they can handle all kinds of traffic, they are usually slower than HTTP proxies because they are more popular and often have a higher load.

 * Transparent proxies – These are a different kind of proxy because their users are usually unaware of their existence. These proxies can be set up by employers or parents who want to monitor users’ online activity and block access to specific websites. Hotels and cafes use them to authenticate users on public Wi-Fi and companies or home users might also set them up to save bandwidth.

5. General Difference between a VPN and a proxy

   * VPNs encrypt traffic while proxys do not
   * VPNs work at OS level while proxies work at application level. They route between applications while VPNs process ALL traffic

   * VPNs can be slower due to the extra work of encryption
   * VPN connections tend to be more reliable than proxy connections
   * VPNs are typically paid products while proxies are usually not.

6. What layer in the OSI model does the Consul proxy operate at ?
    - The built in proxy is a Layer 4 proxy (handling protocol / end to end connectivity)
    - for testing only

7. Sending a SIGHUP ? how ?
   kill -1 will do it. Kill sends signals. kill -l will list all possible signals



Objections

1. Our organization does not like using open source tools

2. How much training do I need to be able to do this ?

3. Isn't it cheaper to just use AWS/Azure tools to do this instead of adding a new component into the mix ?

4. I have load balancers - why do I need Consul ?
