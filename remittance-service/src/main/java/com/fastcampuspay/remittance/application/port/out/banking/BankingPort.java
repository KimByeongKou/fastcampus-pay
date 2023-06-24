package com.fastcampuspay.remittance.application.port.out.banking;

import com.fastcampuspay.remittance.application.port.out.membership.MembershipStatus;

public interface BankingPort {

    BankingInfo getMembershipBankingInfo(String bankName, String bankAccountNumber);

    boolean requestFirmbanking(String bankName, String bankAccountNumber, int amount);
}
