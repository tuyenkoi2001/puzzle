USE [master]
GO
/****** Object:  Database [record]    Script Date: 6/28/2021 7:58:27 PM ******/
CREATE DATABASE [record]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'record', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\record.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'record_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\record_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [record] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [record].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [record] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [record] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [record] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [record] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [record] SET ARITHABORT OFF 
GO
ALTER DATABASE [record] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [record] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [record] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [record] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [record] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [record] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [record] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [record] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [record] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [record] SET  DISABLE_BROKER 
GO
ALTER DATABASE [record] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [record] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [record] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [record] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [record] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [record] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [record] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [record] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [record] SET  MULTI_USER 
GO
ALTER DATABASE [record] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [record] SET DB_CHAINING OFF 
GO
ALTER DATABASE [record] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [record] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [record] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [record] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [record] SET QUERY_STORE = OFF
GO
USE [record]
GO
/****** Object:  Table [dbo].[BestRecord]    Script Date: 6/28/2021 7:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BestRecord](
	[name] [nvarchar](32) NOT NULL,
	[score] [int] NOT NULL
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [record] SET  READ_WRITE 
GO
