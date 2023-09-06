package ru.geraskindenis.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.geraskindenis.controllers.dto.TransferRequest;
import ru.geraskindenis.models.Account;
import ru.geraskindenis.services.TransferService;

@RestController
public class AccountController {

	private final TransferService transferService;

	public AccountController(TransferService transferService) {
		this.transferService = transferService;
	}

	@PostMapping("/transfer")
	public ResponseEntity<String> transferMoney(@RequestBody TransferRequest request) {
		transferService.transferMoney(request.getSenderAccountId(), request.getReceiverAccountId(),
				request.getAmount());
		return ResponseEntity.accepted().body("OK");
	}

	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.accepted().body((List<Account>) transferService.getAllAccounts());
	}

	@PostMapping("/accounts")
	public ResponseEntity<Account> add(@RequestBody Account account) {
		transferService.addAccount(account);
		return ResponseEntity.accepted().body(account);
	}
}
