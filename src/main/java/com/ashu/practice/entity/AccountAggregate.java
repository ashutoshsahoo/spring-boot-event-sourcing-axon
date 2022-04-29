package com.ashu.practice.entity;

import com.ashu.practice.command.CreateAccountCommand;
import com.ashu.practice.command.CreditMoneyCommand;
import com.ashu.practice.command.DebitMoneyCommand;
import com.ashu.practice.common.Status;
import com.ashu.practice.event.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Setter
@Getter
@ToString
public class AccountAggregate {

    @AggregateIdentifier
    private String id;
    private double accountBalance;
    private String currency;
    private String status;

    public AccountAggregate() {
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.getId(),
                createAccountCommand.getAccountBalance(), createAccountCommand.getCurrency()));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent) {
        this.id = accountCreatedEvent.getId();
        this.accountBalance = accountCreatedEvent.getAccountBalance();
        this.currency = accountCreatedEvent.getCurrency();
        this.status = String.valueOf(Status.CREATED);
        AggregateLifecycle.apply(new AccountActivatedEvent(this.id, Status.ACTIVATED));
    }


    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent) {
        this.status = String.valueOf(accountActivatedEvent.getStatus());
    }

    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand) {
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.getId(), creditMoneyCommand.getCreditAmount(), creditMoneyCommand.getCurrency()));
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent) {
        if (this.accountBalance < 0 && (this.accountBalance + moneyCreditedEvent.getCreditAmount()) >= 0) {
            AggregateLifecycle.apply(new AccountActivatedEvent(this.id, Status.ACTIVATED));
        }
        this.accountBalance += moneyCreditedEvent.getCreditAmount();
    }

    @CommandHandler
    protected void on(DebitMoneyCommand debitMoneyCommand) {
        AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.getId(), debitMoneyCommand.getDebitAmount(), debitMoneyCommand.getCurrency()));
    }

    @EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent) {
        if (this.accountBalance >= 0 && (this.accountBalance - moneyDebitedEvent.getDebitAmount()) < 0) {
            AggregateLifecycle.apply(new AccountHeldEvent(this.id, Status.HOLD));
        }
        this.accountBalance -= moneyDebitedEvent.getDebitAmount();
    }

    @EventSourcingHandler
    protected void on(AccountHeldEvent accountHeldEvent) {
        this.status = String.valueOf(accountHeldEvent.getStatus());
    }
}
