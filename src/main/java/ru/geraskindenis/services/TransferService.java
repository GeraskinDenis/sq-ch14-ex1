package ru.geraskindenis.services;

import java.math.BigDecimal;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.geraskindenis.models.Account;
import ru.geraskindenis.repositories.AccountRepository;
import ru.geraskindenis.services.exceptions.AccountNotFoundException;
import ru.geraskindenis.services.exceptions.TransferServiceException;

@Service
public class TransferService {

	private final AccountRepository accountRepository;

	public TransferService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	public void transferMoney(@NonNull long idSender, @NonNull long idReceiver, @NonNull BigDecimal amount) {

		Account sender = accountRepository.findById(idSender)
				.orElseThrow(() -> new AccountNotFoundException(idSender));
		Account receiver = accountRepository.findById(idReceiver)
				.orElseThrow(() -> new AccountNotFoundException(idReceiver));

		BigDecimal senderNewAmount = calculateNewSenderAmount(sender, amount);
		BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

		accountRepository.changeAmount(idSender, senderNewAmount);
		accountRepository.changeAmount(idReceiver, receiverNewAmount);

//		if (senderNewAmount.compareTo(BigDecimal.ZERO) < 0) {
//			throw new TransferServiceException(
//					"There's not enough amount (" + senderNewAmount + ") the sender's account id = " + idSender);
//		}
	}

	public Iterable<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public void addAccount(Account account) {
		accountRepository.save(account);
	}
	
	private BigDecimal calculateNewSenderAmount(Account sender, BigDecimal amount) {
		System.out.println("calculateNewSenderAmount(Account sender, BigDecimal amount) {");
		BigDecimal senderAmount = sender.getAmount();
		BigDecimal newSenderAmount = senderAmount.subtract(amount);
		return newSenderAmount;
	}

}
