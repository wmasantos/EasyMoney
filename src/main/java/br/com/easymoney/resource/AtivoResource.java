package br.com.easymoney.resource;

import br.com.easymoney.entity.AtivoEntity;
import br.com.easymoney.entity.HistoricoEntity;
import br.com.easymoney.entity.ResultWithContentArrayEntity;
import br.com.easymoney.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@Scope("request")
@RestController
public class AtivoResource {

    @Autowired
    AtivoRepository rep;

    @GetMapping("/ativo")
    public ResponseEntity<ResultWithContentArrayEntity<AtivoEntity>> get(){
        ResultWithContentArrayEntity<AtivoEntity> resultWithContentArrayEntity = new ResultWithContentArrayEntity<AtivoEntity>();
        List<AtivoEntity> ativoEntities = rep.getAtivo();

        resultWithContentArrayEntity.setCode(ativoEntities == null ? 1 : 0);
        resultWithContentArrayEntity.setMessage(ativoEntities == null ? "Erro" : "Listagem Efetuada");
        resultWithContentArrayEntity.setContent(ativoEntities);

        return
                resultWithContentArrayEntity.getCode() == 0
                        ? ResponseEntity.ok(resultWithContentArrayEntity)
                        : ResponseEntity.badRequest().body(resultWithContentArrayEntity);
    }

    @GetMapping("/ativo/{idAtivo}")
    public ResponseEntity<ResultWithContentArrayEntity<HistoricoEntity>> get(@PathVariable("idAtivo") int idAtivo){
        ResultWithContentArrayEntity<HistoricoEntity> resultWithContentArrayEntity = new ResultWithContentArrayEntity<HistoricoEntity>();
        List<HistoricoEntity> historicoEntities = rep.getHistorico(idAtivo);

        resultWithContentArrayEntity.setCode(historicoEntities == null ? 1 : 0);
        resultWithContentArrayEntity.setMessage(historicoEntities == null ? "Erro" : "Listagem Efetuada");
        resultWithContentArrayEntity.setContent(historicoEntities);

        return
                resultWithContentArrayEntity.getCode() == 0
                        ? ResponseEntity.ok(resultWithContentArrayEntity)
                        : ResponseEntity.badRequest().body(resultWithContentArrayEntity);
    }
}
