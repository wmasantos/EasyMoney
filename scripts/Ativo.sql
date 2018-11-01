CREATE OR REPLACE FUNCTION listAtivo()
  RETURNS TABLE(
    id INTEGER,
    ativo Public.Ativo.ativo%TYPE,
    "codAtivo" Public.Ativo.codativo%TYPE,
    "precoAtivo" Public.Historico.preco%TYPE
  ) AS $$

/*
Ex................: SELECT * FROM listAtivo();
*/

BEGIN
  RETURN QUERY
  SELECT
         a.id,
         a.ativo,
         a.codativo,
         (SELECT h.preco FROM Historico h WHERE h.idativo = a.id ORDER BY h.id DESC LIMIT 1) as precoAtivo
  FROM Ativo a

  ORDER BY a.codativo;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION listHistorico(IDa INTEGER)
  RETURNS TABLE(
    id INTEGER,
    "date" NUMERIC(10,2),
    "precoAtivo" Public.Historico.preco%TYPE
  ) AS $$

/*
Ex................: SELECT * FROM listHistorico(3);
*/

BEGIN
  RETURN QUERY
  SELECT
         h.id,
         TO_CHAR(h.datahistorico, 'DD')::NUMERIC(10,2),
         h.preco
  FROM Historico h
    WHERE
        h.idativo = IDa
  ORDER BY h.datahistorico;
END;
$$
LANGUAGE plpgsql;