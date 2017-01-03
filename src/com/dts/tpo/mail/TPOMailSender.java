package com.dts.tpo.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.dts.core.util.LoggerManager;
@SuppressWarnings({ "rawtypes", "serial" })
public class TPOMailSender implements java.io.Serializable
{
	MimeMessage messageObj;
	ArrayList toRecipientsList;
	ArrayList ccRecipientsList;
	ArrayList bccRecipientsList;

	ArrayList attachmentsList;

	String subject;
	String bodyMessage;

	String validationError;

	/**
	 * This is to validate the details specified by this program user. Add other
	 * validations if required.
	 */
	private boolean validateDetails()
	{
		if (subject == null)
		{
			validationError = "Subject should not be empty..!!";
			return true;
		}
		else if (toRecipientsList == null || toRecipientsList.size() == 0)
		{
			validationError = "TO Recipient List must be specified";
			return false;
		}
		else if (attachmentsList != null)
		{
			final int noOfAttachements = attachmentsList.size();
			String eachAttachement = null;
			File eachAttachedFile = new File(eachAttachement);
			boolean fileDoesNotExist = false;
			for (int eachAttachmentIndex = 0; eachAttachmentIndex < noOfAttachements; eachAttachmentIndex++)
			{
				eachAttachement = (String) attachmentsList.get(eachAttachmentIndex);
				if (!eachAttachedFile.exists())
				{
					fileDoesNotExist = true;
					break;
				}
			}
			if (fileDoesNotExist)
			{
				validationError = "The attachement : " + eachAttachement + " does not exist, please check and provide proper attachement";
				return false;
			}
		}
		return true;
	}

	public boolean sendMail() throws AddressException, MessagingException
	{
		if (!validateDetails())
		{
			LoggerManager.writeLogInfo(validationError);
			return false;
		}

		final String host = "smtp.gmail.com";
		final String username = "mailer390@gmail.com";
		final String password = "mailer@390";
		final String from = "TPO<mailer390>@gmail.com";
		final Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		final Session session = Session.getInstance(props, null);

		final MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setSubject(subject);

		/**
		 * Add TO Recipients List
		 */
		if (toRecipientsList != null)
		{
			int noOfToRecipients = toRecipientsList.size();
			String toRecipients = null;
			if (noOfToRecipients > 0)
			{
				toRecipients = toRecipientsList.toString();
				noOfToRecipients = toRecipientsList.toString().length();
				toRecipients = toRecipients.substring(1, noOfToRecipients - 1);

				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toRecipients));
			}
		}

		/**
		 * Add CC Recipients List
		 */
		if (ccRecipientsList != null)
		{
			int noOfCCRecipients = ccRecipientsList.size();
			String ccRecipients = null;
			if (noOfCCRecipients > 0)
			{
				ccRecipients = ccRecipientsList.toString();
				noOfCCRecipients = ccRecipientsList.toString().length();
				ccRecipients = ccRecipients.substring(1, noOfCCRecipients - 1);
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccRecipients));
			}
		}

		/**
		 * Add BCC Recipients
		 */
		if (bccRecipientsList != null)
		{
			int noOfBCCRecipients = bccRecipientsList.size();
			String bccRecipients = null;
			if (noOfBCCRecipients > 0)
			{
				bccRecipients = bccRecipientsList.toString();
				noOfBCCRecipients = bccRecipientsList.toString().length();
				bccRecipients = bccRecipients.substring(1, noOfBCCRecipients - 1);
				// System.out.println(bccRecipients);
				message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccRecipients));
			}
		}

		final Multipart multipart = new MimeMultipart();

		if (bodyMessage != null && bodyMessage.length() > 0)
		{
			final BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(bodyMessage);
			multipart.addBodyPart(messageBodyPart);
		}

		int noOfAttachments = 0;

		if (attachmentsList != null)
		{
			noOfAttachments = attachmentsList.size();
			String eachAttachment = null;
			final BodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(eachAttachment);

			for (int eachAttachmentIndex = 0; eachAttachmentIndex < noOfAttachments; eachAttachmentIndex++)
			{
				eachAttachment = (String) attachmentsList.get(eachAttachmentIndex);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(new File(eachAttachment).getName());
				multipart.addBodyPart(messageBodyPart);
			}
		}

		message.setContent(multipart);

		try
		{
			final Transport transport = session.getTransport("smtps");
			transport.connect(host, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			LoggerManager.writeLogInfo("Mail Sent Successfully");
			transport.close();
		}
		catch (SendFailedException sfe)
		{
			LoggerManager.writeLogSevere(sfe);
		}

		return true;
	}

	@SuppressWarnings("unused")
	private static void addAttachment(final Multipart multipart, final String filename)
	{
		try
		{
			final DataSource source = new FileDataSource(filename);
			final BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
	}

	public void setToRecipientsList(final ArrayList toRecipientsList)
	{
		this.toRecipientsList = toRecipientsList;
	}

	public ArrayList getToRecipientsList()
	{
		return toRecipientsList;
	}

	public void setCcRecipientsList(final ArrayList ccRecipientsList)
	{
		this.ccRecipientsList = ccRecipientsList;
	}

	public ArrayList getCcRecipientsList()
	{
		return ccRecipientsList;
	}

	public void setBccRecipientsList(final ArrayList bccRecipientsList)
	{
		this.bccRecipientsList = bccRecipientsList;
	}

	public ArrayList getBccRecipientsList()
	{
		return bccRecipientsList;
	}

	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setBodyMessage(final String bodyMessage)
	{
		this.bodyMessage = bodyMessage;
	}

	public String getBodyMessage()
	{
		return bodyMessage;
	}

	public void setAttachmentsList(final ArrayList attachmentsList)
	{
		this.attachmentsList = attachmentsList;
	}

	public ArrayList getAttachmentsList()
	{
		return attachmentsList;
	}

	@SuppressWarnings("unchecked")
	public static void main(final String[] args) throws MessagingException
	{
		/**
		 * Main program to demonstrate the usage of this Program
		 */
		final TPOMailSender sender = new TPOMailSender();
		final ArrayList toList = new ArrayList();
		toList.add("sudir.319@gmail.com");
		sender.setToRecipientsList(toList);

		final ArrayList ccList = new ArrayList();
		ccList.add("chpraneeth37@gmail.com");
		sender.setCcRecipientsList(ccList);

		final ArrayList bccList = new ArrayList();
		bccList.add("schigurupati@triniti.com");
		// sender.setBccRecipientsList(bccList);

		final ArrayList attachmentsList = new ArrayList();
		attachmentsList.add("C:/Sudheeer/Practice/training_details.xml");
		attachmentsList.add("C:/Sudheeer/Practice/tpo.DMP");
		sender.setAttachmentsList(attachmentsList);

		sender.setSubject("Sending Successfully with Attachments");
		sender.setBodyMessage("Dear Recipient,\n\n\tWe have achieved");
		sender.sendMail();
	}

}