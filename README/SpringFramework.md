### 技术体系结构

#### 总体技术体系

##### 单一架构

​	一个项目，一个工程，导出为一个war包，在一个Tomcat上运行。

![](imgs/saafasaaa.png)

单一架构，项目主要应用技术框架为：Spring、SpringMVC，Mybatis

##### 分布式架构

一个项目，拆分成很多个模块，每个模块是一个IDEA中的一个module。每一个工程都是运行在自己的Tomcat上。模块之间可以互相调用。每一个模块内部可以看成是一个单一架构的应用。

![](imgs/20210331103753528.png)

分布式架构，项目主要应用技术框架：SpringBoot(SSM)、SpringCloud，中间件等

#### 框架概念和理解

框架（Framework）是一个集成了基本结构、规范、设计模式、编程语言和程序库等基础组件的软件系统，它可以用来构建更高级别的应用程序。框架的设计和实现旨在解决特定领域的常见问题，帮助开发人员更高效、更稳定地实现软件开发目标。

**框架的优点**

- 提高开发效率
- 降低开发成本
- 提高应用程序的稳定性
- 提高标准化的解决方案

**框架的缺点**

- 可能存在局限性
- 版本变更和兼容性问题
- 架构风险

### SpringFramework

#### Spring和SpringFramework概念

**广义的Spring：Spring技术栈**

广义上的 Spring 泛指以 Spring Framework 为基础的 Spring 技术栈。

经过十多年的发展，Spring 已经不再是一个单纯的应用框架，而是逐渐发展成为一个由多个不同子项目（模块）组成的成熟技术，例如 Spring Framework、Spring MVC、SpringBoot、Spring Cloud、Spring Data、Spring Security 等，其中 Spring Framework 是其他子项目的基础。

这些子项目涵盖了从企业级应用开发到云计算等各方面的内容，能够帮助开发人员解决软件发展过程中不断产生的各种实际问题，给开发人员带来了更好的开发体验。

**狭义的Spring：Spring Framework基础框架**

狭义的 Spring 特指 Spring Framework，通常我们将它称为 Spring 框架。

经过十多年的发展，Spring 已经不再是一个单纯的应用框架，而是逐渐发展成

#### SpringFramework主要功能模块

SpringFramework框架结构图：

![](imgs/5151850.png)

| 功能模块       | 功能介绍                                              |
| -------------- | ----------------------------------------------------- |
| Core Container | 核心容器，在Spring环境下使用任何功能都必须基于IOC容器 |
| AOP&Aspects    | 面向切面编程                                          |
| TX             | 声明式事务管理                                        |
| Spring MVC     | 提供了面向Web应用程序的集成功能                       |

#### SpringFramework主要优势

- 丰富的生态系统：Spring生态系统非常丰富，支持许多模块和库，如Spring Boot、Spring Security、Sping Cloud等等，可以帮助开发人员快速构建高可靠性的企业应用程序
- 模块化的设计：框架组件之间的松散耦合和模块化设计使得Spring Framework具有良好的可重用性、可扩张性和可维护性。开发人员可以轻松地选择自己需要的模块，根据自己的需求进行开发
- 简化Java开发：Spring Framework简化了Java开发，提供了各种工具和API，可以降低开发复杂度和学习成本。同时Spring Framework支持各种应用场景，包括Web应用程序、RESTful API、消息传递、批处理等等
- 不断创新和发展：Spring Framework开发团队一直在不断创新和发展，保持与最新的技术接轨，为开发人员提供更加游戏和先进的工具和框架。

Spring 使创建 Java 企业应用程序变得容易。它提供了在企业环境中采用 Java 语言所需的一切，支持 Groovy 和 Kotlin 作为 JVM 上的替代语言，并且可以根据应用程序的需求灵活地创建多种架构。从Spring Framework 6.0.6开始，Spring 需要 Java 17+。

